package kz.kbtu.bountyhunters.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public record HuntLogCreateRequest(
        @JsonProperty("criminal_id") @NotNull Long criminalId,
        @NotNull Boolean success,
        String notes) {
}
