package org.bs.oms.services.implementations;

import lombok.RequiredArgsConstructor;
import org.bs.oms.entities.Airbase;
import org.bs.oms.exceptions.AirbaseNotFoundException;
import org.bs.oms.repositories.AirbaseRepo;
import org.bs.oms.services.interfaces.AirbaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AirbaseServiceImpl implements AirbaseService {

    private final AirbaseRepo airbaseRepo;

    @Override
    public Airbase addAirbase(Airbase airbase) {
        return airbaseRepo.save(airbase);
    }

    @Override
    public Airbase airbaseById(Long id) throws AirbaseNotFoundException {
        Airbase airbase = airbaseRepo.findById(id).orElse(null);
        if (airbase == null){
          throw new AirbaseNotFoundException("AirBase not found !!!");
        }else
            return airbase;
    }

    @Override
    public List<Airbase> getAllAirbases() {
        return airbaseRepo.findAll();
    }

    @Override
    public void deleteAirbaseById(Long id) {
        airbaseRepo.deleteById(id);
    }
}
