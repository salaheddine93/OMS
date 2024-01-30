package org.bs.oms.services.implementations;

import lombok.RequiredArgsConstructor;
import org.bs.oms.entities.Aircraft;
import org.bs.oms.repositories.AircraftRepo;
import org.bs.oms.services.interfaces.AircraftService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AircraftServiceImpl implements AircraftService {

    private final AircraftRepo aircraftRepo;

    @Override
    public Aircraft addAircraft(Aircraft aircraft) {
        return aircraftRepo.save(aircraft);
    }

    @Override
    public Aircraft aircraftById(Long id) {
        return aircraftRepo.findById(id).get();
    }

    @Override
    public List<Aircraft> getAllAircrafts() {
        return aircraftRepo.findAll();
    }

    @Override
    public void deleteAircraftById(Long id) {
        aircraftRepo.deleteById(id);
    }
}
