package org.bs.oms.services.interfaces;

import org.bs.oms.entities.Parking;

import java.util.List;

public interface ParkingService {

    Parking addParking(Parking parking);
    Parking parkingById(Long id);
    List<Parking> getAllParking();
    void deleteParkingById(Long id);
}
