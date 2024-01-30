package org.bs.oms.services.interfaces;

import org.bs.oms.entities.AircraftMaker;

import java.util.List;

public interface AircraftMakerService {

    AircraftMaker addAircraftMaker(AircraftMaker aircraftMaker);
    AircraftMaker aircraftMakerById(Long id);
    List<AircraftMaker> getAllAircraftMakers();
    void deleteAircraftMakerById(Long id);
}
