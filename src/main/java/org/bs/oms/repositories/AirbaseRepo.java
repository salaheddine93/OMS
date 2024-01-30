package org.bs.oms.repositories;

import org.bs.oms.entities.Airbase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirbaseRepo extends JpaRepository<Airbase, Long> {
}