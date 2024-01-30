package org.bs.oms.controllers;

import lombok.RequiredArgsConstructor;
import org.bs.oms.entities.AircraftMaker;
import org.bs.oms.services.interfaces.AircraftMakerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AircraftMakerController {

    private final AircraftMakerService aircraftMakerService;

    @GetMapping(path = "/aircraftMakers")
    public List<AircraftMaker> aircraftMakerList(){
        return aircraftMakerService.getAllAircraftMakers();
    }

    @PostMapping(path = "/addAircraftMaker")
    public AircraftMaker saveAircraft(@RequestBody AircraftMaker aircraftMaker){
        return aircraftMakerService.addAircraftMaker(aircraftMaker);
    }

    @GetMapping(path = "/aircraftMakers/{id}")
    public AircraftMaker getAircraft(@PathVariable Long id){
        return aircraftMakerService.aircraftMakerById(id);
    }

    @DeleteMapping(path = "/aircraftMakers/{id}")
    public void deleteAircraft(@PathVariable Long id){
        aircraftMakerService.deleteAircraftMakerById(id);
    }
}
