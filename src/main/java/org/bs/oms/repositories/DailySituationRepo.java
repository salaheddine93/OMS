package org.bs.oms.repositories;

import org.bs.oms.entities.DailySituation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailySituationRepo extends JpaRepository<DailySituation, Long> {
}
