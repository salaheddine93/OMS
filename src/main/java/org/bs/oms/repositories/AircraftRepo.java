package org.bs.oms.repositories;

import org.bs.oms.entities.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AircraftRepo extends JpaRepository<Aircraft, Long> {
}
