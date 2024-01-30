package org.bs.oms.controllers;

import lombok.RequiredArgsConstructor;
import org.bs.oms.entities.Aircraft;
import org.bs.oms.services.interfaces.AircraftService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AircraftController {

    private final AircraftService aircraftService;

    @GetMapping(path = "/aircraft")
    public List<Aircraft> aircraftList(){
        return aircraftService.getAllAircrafts();
    }

    @PostMapping(path = "/addAircraft")
    public Aircraft saveAircraft(@RequestBody Aircraft aircraft){
        return aircraftService.addAircraft(aircraft);
    }

    @GetMapping(path = "/aircraft/{id}")
    public Aircraft getAircraft(@PathVariable Long id){
        return aircraftService.aircraftById(id);
    }

    @DeleteMapping(path = "/aircraft/{id}")
    public void deleteAircraft(@PathVariable Long id){
        aircraftService.deleteAircraftById(id);
    }
}
