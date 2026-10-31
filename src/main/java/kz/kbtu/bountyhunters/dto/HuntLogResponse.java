package kz.kbtu.bountyhunters.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import kz.kbtu.bountyhunters.entity.HuntLog;

import java.time.LocalDateTime;

public record HuntLogResponse(
        Long id,
        @JsonProperty("criminal_id") Long criminalId,
        boolean success,
        String notes,
        @JsonProperty("created_at") LocalDateTime createdAt) {

    public static HuntLogResponse from(HuntLog hunt) {
        return new HuntLogResponse(
                hunt.getId(),
                hunt.getCriminal().getId(),
                hunt.isSuccess(),
                hunt.getNotes(),
                hunt.getCreatedAt());
    }
}