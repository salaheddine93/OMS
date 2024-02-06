package org.bs.oms.controllers;

import lombok.RequiredArgsConstructor;
import org.bs.oms.dto.requestDTO.SquadronRequestDTO;
import org.bs.oms.dto.responseDTO.SquadronResponseDTO;
import org.bs.oms.services.interfaces.SquadronService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/squadrons")
public class SquadronController {

    private final SquadronService squadronService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<SquadronResponseDTO>> squadronsList(){
        return new ResponseEntity<>(squadronService.getAllSquadrons(), HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<SquadronResponseDTO> saveSquadron(@RequestBody SquadronRequestDTO squadronRequestDTO){
        return new ResponseEntity<>(squadronService.addSquadron(squadronRequestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SquadronResponseDTO> updateSquadron(@RequestBody SquadronRequestDTO squadronRequestDTO, @PathVariable Long id){
        return new ResponseEntity<>(squadronService.updateSquadron(squadronRequestDTO, id), HttpStatus.ACCEPTED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<SquadronResponseDTO> getSquadron(@PathVariable Long id){
        return new ResponseEntity<>(squadronService.squadronById(id), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteSquadron(@PathVariable Long id){
        squadronService.deleteSquadronById(id);
        return ResponseEntity.noContent().build();
    }
}
