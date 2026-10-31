package kz.kbtu.bountyhunters.repository;

import kz.kbtu.bountyhunters.entity.WantedCriminal;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface WantedCriminalRepository extends JpaRepository<WantedCriminal, Long> {

    @Query("""
            SELECT c FROM WantedCriminal c
            WHERE (:minReward IS NULL OR c.reward >= :minReward)
              AND (:maxReward IS NULL OR c.reward <= :maxReward)
              AND (:armed IS NULL OR c.armed = :armed)
              AND (:hasCrew IS NULL OR c.hasCrew = :hasCrew)
              AND (:escapeMaster IS NULL OR c.escapeMaster = :escapeMaster)
            """)
    List<WantedCriminal> search(@Param("minReward") BigDecimal minReward,
                                @Param("maxReward") BigDecimal maxReward,
                                @Param("armed") Boolean armed,
                                @Param("hasCrew") Boolean hasCrew,
                                @Param("escapeMaster") Boolean escapeMaster,
                                Sort sort);
}
