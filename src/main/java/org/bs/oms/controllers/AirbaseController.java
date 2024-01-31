package org.bs.oms.controllers;

import lombok.RequiredArgsConstructor;
import org.bs.oms.entities.Airbase;
import org.bs.oms.exceptions.AirbaseNotFoundException;
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
    public ResponseEntity<List<Airbase>> airbasesList(){
        return new ResponseEntity<>(airbaseService.getAllAirbases(), HttpStatus.OK);
    }

    @PostMapping(path = "/addAirbase")
    public ResponseEntity<Airbase> saveAirbase(@RequestBody Airbase airbase){
        return new ResponseEntity<>(airbaseService.addAirbase(airbase), HttpStatus.CREATED);
    }

    @GetMapping(path = "/airbases/{id}")
    public Airbase getAirbase(@PathVariable Long id) throws AirbaseNotFoundException {
        return airbaseService.airbaseById(id);
    }

    @DeleteMapping(path = "/airbases/{id}")
    public ResponseEntity<?> deleteAirbase(@PathVariable Long id){
        airbaseService.deleteAirbaseById(id);
        return ResponseEntity.noContent().build();
    }
}
