package org.bs.oms.controllers;

import lombok.RequiredArgsConstructor;
import org.bs.oms.dto.requestDTO.AircraftMakerRequestDTO;
import org.bs.oms.dto.responseDTO.AircraftMakerResponseDTO;
import org.bs.oms.services.interfaces.AircraftMakerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/aircraftMakers")
public class AircraftMakerController {

    private final AircraftMakerService aircraftMakerService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<AircraftMakerResponseDTO>> aircraftMakerList(){
        return new ResponseEntity<>(aircraftMakerService.getAllAircraftMakers(), HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<AircraftMakerResponseDTO> saveAircraft(@RequestBody AircraftMakerRequestDTO aircraftMakerRequestDTO){
        return new ResponseEntity<>(aircraftMakerService.addAircraftMaker(aircraftMakerRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AircraftMakerResponseDTO> getAircraft(@PathVariable Long id){
        return new ResponseEntity<>(aircraftMakerService.aircraftMakerById(id), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteAircraft(@PathVariable Long id){
        aircraftMakerService.deleteAircraftMakerById(id);
        return ResponseEntity.noContent().build();
    }
}
