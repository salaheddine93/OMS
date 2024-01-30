package org.bs.oms.repositories;

import org.bs.oms.entities.AircraftMaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AircraftMakerRepo extends JpaRepository<AircraftMaker, Long> {
}
