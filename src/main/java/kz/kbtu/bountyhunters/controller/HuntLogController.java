package kz.kbtu.bountyhunters.controller;

import jakarta.validation.Valid;
import kz.kbtu.bountyhunters.dto.HuntLogCreateRequest;
import kz.kbtu.bountyhunters.dto.HuntLogResponse;
import kz.kbtu.bountyhunters.dto.HuntLogUpdateRequest;
import kz.kbtu.bountyhunters.service.HuntLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/hunts")
@RequiredArgsConstructor
public class HuntLogController {

    private final HuntLogService huntLogService;

    @GetMapping({"", "/"})
    public List<HuntLogResponse> list(@RequestParam(name = "criminal_id", required = false) Long criminalId) {
        return huntLogService.list(criminalId);
    }

    @GetMapping({"/{id}", "/{id}/"})
    public HuntLogResponse get(@PathVariable Long id) {
        return huntLogService.get(id);
    }

    @PostMapping({"", "/"})
    @ResponseStatus(HttpStatus.CREATED)
    public HuntLogResponse create(@Valid @RequestBody HuntLogCreateRequest request) {
        return huntLogService.create(request);
    }

    @PatchMapping({"/{id}", "/{id}/"})
    public HuntLogResponse update(@PathVariable Long id, @RequestBody HuntLogUpdateRequest request) {
        return huntLogService.update(id, request);
    }

    @DeleteMapping({"/{id}", "/{id}/"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        huntLogService.delete(id);
    }
}
