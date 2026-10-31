package kz.kbtu.bountyhunters.service;

import kz.kbtu.bountyhunters.dto.HuntLogCreateRequest;
import kz.kbtu.bountyhunters.dto.HuntLogResponse;
import kz.kbtu.bountyhunters.dto.HuntLogUpdateRequest;
import kz.kbtu.bountyhunters.entity.HuntLog;
import kz.kbtu.bountyhunters.entity.WantedCriminal;
import kz.kbtu.bountyhunters.exception.NotFoundException;
import kz.kbtu.bountyhunters.repository.HuntLogRepository;
import kz.kbtu.bountyhunters.repository.WantedCriminalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HuntLogService {

    private final HuntLogRepository huntLogRepository;
    private final WantedCriminalRepository wantedCriminalRepository;

    @Transactional(readOnly = true)
    public List<HuntLogResponse> list(Long criminalId) {
        List<HuntLog> hunts = criminalId == null
                ? huntLogRepository.findAll(Sort.by("id"))
                : huntLogRepository.findByCriminalId(criminalId);
        return hunts.stream().map(HuntLogResponse::from).toList();
    }

    @Transactional(readOnly = true)
    public HuntLogResponse get(Long id) {
        return HuntLogResponse.from(findHunt(id));
    }

    @Transactional
    public HuntLogResponse create(HuntLogCreateRequest request) {
        WantedCriminal criminal = wantedCriminalRepository.findById(request.criminalId())
                .orElseThrow(() -> new NotFoundException("Criminal with id " + request.criminalId() + " not found"));
        HuntLog hunt = new HuntLog();
        hunt.setCriminal(criminal);
        hunt.setSuccess(request.success());
        hunt.setNotes(request.notes());
        return HuntLogResponse.from(huntLogRepository.save(hunt));
    }

    @Transactional
    public HuntLogResponse update(Long id, HuntLogUpdateRequest request) {
        if (request.success() == null && request.notes() == null) {
            throw new IllegalArgumentException("Provide 'success' or 'notes' to update");
        }
        HuntLog hunt = findHunt(id);
        if (request.success() != null) {
            hunt.setSuccess(request.success());
        }
        if (request.notes() != null) {
            hunt.setNotes(request.notes());
        }
        return HuntLogResponse.from(huntLogRepository.save(hunt));
    }

    public void delete(Long id) {
        huntLogRepository.delete(findHunt(id));
    }

    private HuntLog findHunt(Long id) {
        return huntLogRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Hunt log with id " + id + " not found"));
    }
}
