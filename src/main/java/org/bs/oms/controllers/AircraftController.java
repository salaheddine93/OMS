package org.bs.oms.controllers;

import lombok.RequiredArgsConstructor;
import org.bs.oms.dto.requestDTO.AircraftRequestDTO;
import org.bs.oms.dto.responseDTO.AircraftResponseDTO;
import org.bs.oms.services.interfaces.AircraftService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/aircraft")
public class AircraftController {

    private final AircraftService aircraftService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<AircraftResponseDTO>> aircraftList(){
        return new ResponseEntity<>(aircraftService.getAllAircrafts(), HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<AircraftResponseDTO> saveAircraft(@RequestBody AircraftRequestDTO aircraftRequestDTO){
        return new ResponseEntity<>(aircraftService.addAircraft(aircraftRequestDTO), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<AircraftResponseDTO> updateAircraft(@RequestBody AircraftRequestDTO aircraftRequestDTO, @PathVariable Long id){
        return new ResponseEntity<>(aircraftService.updateAircraft(aircraftRequestDTO, id), HttpStatus.ACCEPTED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AircraftResponseDTO> getAircraft(@PathVariable Long id){
        return new ResponseEntity<>(aircraftService.aircraftById(id), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteAircraft(@PathVariable Long id){
        aircraftService.deleteAircraftById(id);
        return ResponseEntity.noContent().build();
    }
}
