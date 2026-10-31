package kz.kbtu.bountyhunters.controller;

import kz.kbtu.bountyhunters.dto.CriminalResponse;
import kz.kbtu.bountyhunters.service.WantedCriminalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/criminals")
@RequiredArgsConstructor
public class WantedCriminalController {

    private final WantedCriminalService wantedCriminalService;

    @GetMapping({"", "/"})
    public List<CriminalResponse> list(
            @RequestParam(name = "min_reward", required = false) BigDecimal minReward,
            @RequestParam(name = "max_reward", required = false) BigDecimal maxReward,
            @RequestParam(name = "armed", required = false) Boolean armed,
            @RequestParam(name = "has_crew", required = false) Boolean hasCrew,
            @RequestParam(name = "escape_master", required = false) Boolean escapeMaster,
            @RequestParam(name = "sort", required = false) String sort) {
        return wantedCriminalService.list(minReward, maxReward, armed, hasCrew, escapeMaster, sort);
    }

    @GetMapping({"/{id}", "/{id}/"})
    public CriminalResponse get(@PathVariable Long id) {
        return wantedCriminalService.get(id);
    }
}
