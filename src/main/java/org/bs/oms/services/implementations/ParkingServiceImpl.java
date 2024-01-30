package org.bs.oms.services.implementations;

import lombok.RequiredArgsConstructor;
import org.bs.oms.entities.Parking;
import org.bs.oms.repositories.ParkingRepo;
import org.bs.oms.services.interfaces.ParkingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParkingServiceImpl implements ParkingService {

    private final ParkingRepo parkingRepo;

    @Override
    public Parking addParking(Parking parking) {
        return parkingRepo.save(parking);
    }

    @Override
    public Parking parkingById(Long id) {
        return parkingRepo.findById(id).get();
    }

    @Override
    public List<Parking> getAllParking() {
        return parkingRepo.findAll();
    }

    @Override
    public void deleteParkingById(Long id) {
        parkingRepo.deleteById(id

        );
    }
}
