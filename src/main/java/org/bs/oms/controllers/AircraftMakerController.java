package org.bs.oms.controllers;

import lombok.RequiredArgsConstructor;
import org.bs.oms.dto.requestDTO.AircraftMakerRequestDTO;
import org.bs.oms.dto.responseDTO.AircraftMakerResponseDTO;
import org.bs.oms.entities.AircraftMaker;
import org.bs.oms.services.interfaces.AircraftMakerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/aircraftMakers")
public class AircraftMakerController {

    private final AircraftMakerService aircraftMakerService;

    @GetMapping(path = "/all")
    public List<AircraftMakerResponseDTO> aircraftMakerList(){
        return aircraftMakerService.getAllAircraftMakers();
    }

    @PostMapping(path = "/add")
    public AircraftMakerResponseDTO saveAircraft(@RequestBody AircraftMakerRequestDTO aircraftMakerRequestDTO){
        return aircraftMakerService.addAircraftMaker(aircraftMakerRequestDTO);
    }

    @GetMapping(path = "/{id}")
    public AircraftMakerResponseDTO getAircraft(@PathVariable Long id){
        return aircraftMakerService.aircraftMakerById(id);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteAircraft(@PathVariable Long id){
        aircraftMakerService.deleteAircraftMakerById(id);
    }
}
