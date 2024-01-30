package org.bs.oms.services.implementations;

import lombok.RequiredArgsConstructor;
import org.bs.oms.entities.AircraftMaker;
import org.bs.oms.repositories.AircraftMakerRepo;
import org.bs.oms.services.interfaces.AircraftMakerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AircraftMakerServiceImpl implements AircraftMakerService {


    private final AircraftMakerRepo aircraftMakerRepo;


    @Override
    public AircraftMaker addAircraftMaker(AircraftMaker aircraftMaker) {
        return aircraftMakerRepo.save(aircraftMaker);
    }

    @Override
    public AircraftMaker aircraftMakerById(Long id) {
        return aircraftMakerRepo.findById(id).get();
    }

    @Override
    public List<AircraftMaker> getAllAircraftMakers() {
        return aircraftMakerRepo.findAll();
    }

    @Override
    public void deleteAircraftMakerById(Long id) {
        aircraftMakerRepo.deleteById(id);
    }
}