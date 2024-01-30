package org.bs.oms.controllers;

import lombok.RequiredArgsConstructor;
import org.bs.oms.entities.Squadron;
import org.bs.oms.services.interfaces.SquadronService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SquadronController {

    private final SquadronService squadronService;

    @GetMapping(path = "/squadrons")
    public List<Squadron> squadronsList(){
        return squadronService.getAllSquadrons();
    }

    @PostMapping(path = "/addSquadron")
    public Squadron saveSquadron(@RequestBody Squadron squadron){
        return squadronService.addSquadron(squadron);
    }

    @GetMapping(path = "/squadrons/{id}")
    public Squadron getSquadron(@PathVariable Long id){
        return squadronService.squadronById(id);
    }

    @DeleteMapping(path = "/squadrons/{id}")
    public void deleteSquadron(@PathVariable Long id){
        squadronService.deleteSquadronById(id);
    }
}
