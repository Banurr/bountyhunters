package kz.kbtu.bountyhunters.repository;

import kz.kbtu.bountyhunters.entity.HuntLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HuntLogRepository extends JpaRepository<HuntLog, Long> {

    List<HuntLog> findByCriminalId(Long criminalId);
}
