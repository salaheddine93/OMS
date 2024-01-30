package org.bs.oms.services.interfaces;

import org.bs.oms.entities.Airbase;
import org.bs.oms.exceptions.AirbaseNotFoundException;

import java.util.List;

public interface AirbaseService {
    Airbase addAirbase(Airbase airbase);
    Airbase airbaseById(Long id) throws AirbaseNotFoundException;
    List<Airbase> getAllAirbases();
    void deleteAirbaseById(Long id);
}
