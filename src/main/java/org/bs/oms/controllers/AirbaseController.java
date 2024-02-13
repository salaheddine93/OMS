package org.bs.oms.controllers;

import lombok.RequiredArgsConstructor;
import org.bs.oms.dto.requestDTO.AirbaseRequestDTO;
import org.bs.oms.dto.responseDTO.AirbaseResponseDTO;
import org.bs.oms.services.interfaces.AirbaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/airbases")
public class AirbaseController {

    private final AirbaseService airbaseService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<AirbaseResponseDTO>> airbasesList(){
        return new ResponseEntity<>(airbaseService.getAllAirbases(), HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<AirbaseResponseDTO> saveAirbase(@RequestBody AirbaseRequestDTO airbaseRequestDTO){
        return new ResponseEntity<>(airbaseService.addAirbase(airbaseRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AirbaseResponseDTO> getAirbase(@PathVariable Long id){
        return new ResponseEntity<>(airbaseService.airbaseById(id), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteAirbase(@PathVariable Long id){
        return new ResponseEntity<>(airbaseService.deleteAirbaseById(id), HttpStatus.NO_CONTENT);
         //ResponseEntity.noContent().build();

        //**** Why it does not display the message after the deleting process
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<AirbaseResponseDTO> updateAirbase(@RequestBody AirbaseRequestDTO airbaseRequestDTO, @PathVariable Long id) {
        return new ResponseEntity<>(airbaseService.updateAirbase(airbaseRequestDTO, id), HttpStatus.ACCEPTED);
    }
}
