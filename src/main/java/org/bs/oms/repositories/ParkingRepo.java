package org.bs.oms.repositories;

import org.bs.oms.entities.Parking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingRepo extends JpaRepository<Parking, Long> {
}
