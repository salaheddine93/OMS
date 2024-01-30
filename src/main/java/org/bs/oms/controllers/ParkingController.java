package org.bs.oms.controllers;

import lombok.RequiredArgsConstructor;
import org.bs.oms.entities.Parking;
import org.bs.oms.services.interfaces.ParkingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ParkingController {

    private final ParkingService parkingService;

    @GetMapping(path = "/parking")
    public List<Parking> parkingList(){
        return parkingService.getAllParking();
    }

    @PostMapping(path = "/addParking")
    public Parking saveParking(@RequestBody Parking parking){
        return parkingService.addParking(parking);
    }

    @GetMapping(path = "/parking/{id}")
    public Parking getParking(@PathVariable Long id){
        return parkingService.parkingById(id);
    }

    @DeleteMapping(path = "/parking/{id}")
    public void deleteParking(@PathVariable Long id){
        parkingService.deleteParkingById(id);
    }
}
