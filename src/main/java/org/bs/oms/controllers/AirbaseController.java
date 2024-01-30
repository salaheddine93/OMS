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
    public List<Airbase> airbasesList(){
        return airbaseService.getAllAirbases();
    }

    @PostMapping(path = "/addAirbase")
    public ResponseEntity<Airbase> saveAirbase(@RequestBody Airbase airbase){
        return ResponseEntity.status(HttpStatus.CREATED).body(airbaseService.addAirbase(airbase));
    }

    @GetMapping(path = "/airbases/{id}")
    public Airbase getAirbase(@PathVariable Long id) throws AirbaseNotFoundException {
        return airbaseService.airbaseById(id);
    }

    @DeleteMapping(path = "/airbases/{id}")
    public void deleteAirbase(@PathVariable Long id){
        airbaseService.deleteAirbaseById(id);
    }
}
