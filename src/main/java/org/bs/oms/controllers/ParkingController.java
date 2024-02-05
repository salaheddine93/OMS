package org.bs.oms.controllers;

import lombok.RequiredArgsConstructor;
import org.bs.oms.dto.requestDTO.ParkingRequestDTO;
import org.bs.oms.dto.responseDTO.ParkingResponseDTO;
import org.bs.oms.services.interfaces.ParkingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/parking")
public class ParkingController {

    private final ParkingService parkingService;

    @GetMapping(path = "/all")
    public List<ParkingResponseDTO> parkingList(){
        return parkingService.getAllParking();
    }

    @PostMapping(path = "/add")
    public ParkingResponseDTO saveParking(@RequestBody ParkingRequestDTO parkingRequestDTO){
        return parkingService.addParking(parkingRequestDTO);
    }

    @PutMapping("/{id}")
    public ParkingResponseDTO updateParking(@RequestBody ParkingRequestDTO parkingRequestDTO, @PathVariable Long id){
        return parkingService.updateParking(parkingRequestDTO, id);
    }

    @GetMapping(path = "/{id}")
    public ParkingResponseDTO getParking(@PathVariable Long id){
        return parkingService.parkingById(id);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteParking(@PathVariable Long id){
        parkingService.deleteParkingById(id);
    }
}
