package org.bs.oms.controllers;

import lombok.RequiredArgsConstructor;
import org.bs.oms.dto.requestDto.AircraftRequestDto;
import org.bs.oms.dto.responseDto.AircraftResponseDto;
import org.bs.oms.entities.Aircraft;
import org.bs.oms.services.interfaces.AircraftService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AircraftController {

    private final AircraftService aircraftService;

    @GetMapping(path = "/aircraft")
    public List<AircraftResponseDto> aircraftList(){
        return aircraftService.getAllAircrafts();
    }

    @PostMapping(path = "/addAircraft")
    public AircraftResponseDto saveAircraft(@RequestBody AircraftRequestDto aircraftRequestDto){
        return aircraftService.addAircraft(aircraftRequestDto);
    }

    @PutMapping(path = "/aicraft/{id}")
    public AircraftResponseDto updateAircraft(@RequestBody AircraftRequestDto aircraftRequestDto, @PathVariable Long id){
        return aircraftService.updateAircraft(aircraftRequestDto, id);
    }

    @GetMapping(path = "/aircraft/{id}")
    public AircraftResponseDto getAircraft(@PathVariable Long id){
        return aircraftService.aircraftById(id);
    }

    @DeleteMapping(path = "/aircraft/{id}")
    public void deleteAircraft(@PathVariable Long id){
        aircraftService.deleteAircraftById(id);
    }
}
