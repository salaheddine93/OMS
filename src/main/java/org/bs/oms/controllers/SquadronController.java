package org.bs.oms.controllers;

import lombok.RequiredArgsConstructor;
import org.bs.oms.dto.requestDto.SquadronRequestDto;
import org.bs.oms.dto.responseDto.SquadronResponseDto;
import org.bs.oms.services.interfaces.SquadronService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SquadronController {

    private final SquadronService squadronService;

    @GetMapping(path = "/squadrons")
    public List<SquadronResponseDto> squadronsList(){
        return squadronService.getAllSquadrons();
    }

    @PostMapping(path = "/addSquadron")
    public SquadronResponseDto saveSquadron(@RequestBody SquadronRequestDto squadronRequestDto){
        return squadronService.addSquadron(squadronRequestDto);
    }

    @PutMapping("/squadrons/{id}")
    public SquadronResponseDto updateSquadron(@RequestBody SquadronRequestDto squadronRequestDto, @PathVariable Long id){
        return squadronService.updateSquadron(squadronRequestDto, id);
    }

    @GetMapping(path = "/squadrons/{id}")
    public SquadronResponseDto getSquadron(@PathVariable Long id){
        return squadronService.squadronById(id);
    }

    @DeleteMapping(path = "/squadrons/{id}")
    public void deleteSquadron(@PathVariable Long id){
        squadronService.deleteSquadronById(id);
    }
}
