package org.bs.oms.controllers;

import lombok.RequiredArgsConstructor;
import org.bs.oms.dto.requestDto.ParkingRequestDto;
import org.bs.oms.dto.responseDto.ParkingResponseDto;
import org.bs.oms.services.interfaces.ParkingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ParkingController {

    private final ParkingService parkingService;

    @GetMapping(path = "/parking")
    public List<ParkingResponseDto> parkingList(){
        return parkingService.getAllParking();
    }

    @PostMapping(path = "/addParking")
    public ParkingResponseDto saveParking(@RequestBody ParkingRequestDto parkingRequestDto){
        return parkingService.addParking(parkingRequestDto);
    }

    @PutMapping("/parking/{id}")
    public ParkingResponseDto updateParking(@RequestBody ParkingRequestDto parkingRequestDto, @PathVariable Long id){
        return parkingService.updateParking(parkingRequestDto, id);
    }

    @GetMapping(path = "/parking/{id}")
    public ParkingResponseDto getParking(@PathVariable Long id){
        return parkingService.parkingById(id);
    }

    @DeleteMapping(path = "/parking/{id}")
    public void deleteParking(@PathVariable Long id){
        parkingService.deleteParkingById(id);
    }
}
