package org.bs.oms.controllers;

import lombok.RequiredArgsConstructor;
import org.bs.oms.dto.requestDTO.SquadronRequestDTO;
import org.bs.oms.dto.responseDTO.SquadronResponseDTO;
import org.bs.oms.services.interfaces.SquadronService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/squadrons")
public class SquadronController {

    private final SquadronService squadronService;

    @GetMapping(path = "/all")
    public List<SquadronResponseDTO> squadronsList(){
        return squadronService.getAllSquadrons();
    }

    @PostMapping(path = "/add")
    public SquadronResponseDTO saveSquadron(@RequestBody SquadronRequestDTO squadronRequestDTO){
        return squadronService.addSquadron(squadronRequestDTO);
    }

    @PutMapping("/{id}")
    public SquadronResponseDTO updateSquadron(@RequestBody SquadronRequestDTO squadronRequestDTO, @PathVariable Long id){
        return squadronService.updateSquadron(squadronRequestDTO, id);
    }

    @GetMapping(path = "/{id}")
    public SquadronResponseDTO getSquadron(@PathVariable Long id){
        return squadronService.squadronById(id);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteSquadron(@PathVariable Long id){
        squadronService.deleteSquadronById(id);
    }
}
