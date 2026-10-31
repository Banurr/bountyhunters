package kz.kbtu.bountyhunters.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import kz.kbtu.bountyhunters.entity.WantedCriminal;
import lombok.Data;

import java.math.BigDecimal;

public record CriminalResponse(
        Long id,
        String name,
        String nickname,
        BigDecimal reward,
        Double latitude,
        Double longitude,
        @JsonProperty("location_note") String locationNote,
        Integer difficulty,
        boolean armed,
        @JsonProperty("has_crew") boolean hasCrew,
        @JsonProperty("escape_master") boolean escapeMaster) {

    public static CriminalResponse from(WantedCriminal c) {
        return new CriminalResponse(
                c.getId(),
                c.getName(),
                c.getNickname(),
                c.getReward(),
                c.getLatitude(),
                c.getLongitude(),
                c.getLocationNote(),
                c.getDifficulty(),
                c.isArmed(),
                c.isHasCrew(),
                c.isEscapeMaster());
    }
}
