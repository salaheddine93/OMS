package org.bs.oms.controllers;

import lombok.RequiredArgsConstructor;
import org.bs.oms.dto.requestDto.AirbaseRequestDto;
import org.bs.oms.dto.responseDto.AirbaseResponseDto;
import org.bs.oms.services.interfaces.AirbaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AirbaseController {

    private final AirbaseService airbaseService;

    @GetMapping(path = "/airbases")
    public ResponseEntity<List<AirbaseResponseDto>> airbasesList(){
        return new ResponseEntity<>(airbaseService.getAllAirbases(), HttpStatus.OK);
    }

    @PostMapping(path = "/addAirbase")
    public ResponseEntity<AirbaseResponseDto> saveAirbase(@RequestBody AirbaseRequestDto airbaseRequestDto){
        return new ResponseEntity<>(airbaseService.addAirbase(airbaseRequestDto), HttpStatus.CREATED);
    }

    @GetMapping(path = "/airbases/{id}")
    public ResponseEntity<AirbaseResponseDto> getAirbase(@PathVariable Long id){
        return new ResponseEntity<>(airbaseService.airbaseById(id), HttpStatus.OK);
    }

    @DeleteMapping(path = "/airbases/{id}")
    public ResponseEntity<?> deleteAirbase(@PathVariable Long id){
        airbaseService.deleteAirbaseById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/airbases/{id}")
    public ResponseEntity<AirbaseResponseDto> updateAirbase(@RequestBody AirbaseRequestDto airbaseRequestDto, @PathVariable Long id) {
        return new ResponseEntity<>(airbaseService.updateAirbase(airbaseRequestDto, id), HttpStatus.ACCEPTED);
    }
}
