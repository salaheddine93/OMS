package org.bs.oms.controllers;

import lombok.RequiredArgsConstructor;
import org.bs.oms.dto.requestDTO.AircraftRequestDTO;
import org.bs.oms.dto.responseDTO.AircraftResponseDTO;
import org.bs.oms.services.interfaces.AircraftService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/aircraft")
public class AircraftController {

    private final AircraftService aircraftService;

    @GetMapping(path = "/all")
    public List<AircraftResponseDTO> aircraftList(){
        return aircraftService.getAllAircrafts();
    }

    @PostMapping(path = "/add")
    public AircraftResponseDTO saveAircraft(@RequestBody AircraftRequestDTO aircraftRequestDTO){
        return aircraftService.addAircraft(aircraftRequestDTO);
    }

    @PutMapping(path = "/{id}")
    public AircraftResponseDTO updateAircraft(@RequestBody AircraftRequestDTO aircraftRequestDTO, @PathVariable Long id){
        return aircraftService.updateAircraft(aircraftRequestDTO, id);
    }

    @GetMapping(path = "/{id}")
    public AircraftResponseDTO getAircraft(@PathVariable Long id){
        return aircraftService.aircraftById(id);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteAircraft(@PathVariable Long id){
        aircraftService.deleteAircraftById(id);
    }
}
