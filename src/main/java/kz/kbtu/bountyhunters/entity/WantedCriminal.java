package kz.kbtu.bountyhunters.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "wanted_criminals")
public class WantedCriminal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private BigDecimal reward;

    private Double latitude;

    private Double longitude;

    @Column(name = "location_note")
    private String locationNote;

    @Column(nullable = false)
    private Integer difficulty;

    @Column(nullable = false)
    private boolean armed;

    @Column(name = "has_crew", nullable = false)
    private boolean hasCrew;

    @Column(name = "escape_master", nullable = false)
    private boolean escapeMaster;

    @JsonIgnore
    @OneToMany(mappedBy = "criminal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HuntLog> hunts = new ArrayList<>();
}
