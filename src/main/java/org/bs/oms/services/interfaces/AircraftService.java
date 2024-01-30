package org.bs.oms.services.interfaces;

import org.bs.oms.entities.Aircraft;

import java.util.List;

public interface AircraftService {

    Aircraft addAircraft(Aircraft aircraft);
    Aircraft aircraftById(Long id);
    List<Aircraft> getAllAircrafts();
    void deleteAircraftById(Long id);
}
