package kz.kbtu.bountyhunters.service;

import kz.kbtu.bountyhunters.dto.CriminalResponse;
import kz.kbtu.bountyhunters.exception.NotFoundException;
import kz.kbtu.bountyhunters.repository.WantedCriminalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WantedCriminalService {

    private final WantedCriminalRepository wantedCriminalRepository;

    public List<CriminalResponse> list(BigDecimal minReward,
                                       BigDecimal maxReward,
                                       Boolean armed,
                                       Boolean hasCrew,
                                       Boolean escapeMaster,
                                       String sort) {
        return wantedCriminalRepository
                .search(minReward, maxReward, armed, hasCrew, escapeMaster, parseSort(sort))
                .stream()
                .map(CriminalResponse::from)
                .toList();
    }

    public CriminalResponse get(Long id) {
        return wantedCriminalRepository.findById(id)
                .map(CriminalResponse::from)
                .orElseThrow(() -> new NotFoundException("Criminal with id " + id + " not found"));
    }

    private Sort parseSort(String sort) {
        if (sort == null || sort.isBlank()) {
            return Sort.by("id");
        }
        if (sort.equals("reward")) {
            return Sort.by(Sort.Direction.ASC, "reward");
        }
        if (sort.equals("-reward")) {
            return Sort.by(Sort.Direction.DESC, "reward");
        }
        throw new IllegalArgumentException("sort must be 'reward' or '-reward'");
    }
}
