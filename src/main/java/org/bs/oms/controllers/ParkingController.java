package org.bs.oms.controllers;

import lombok.RequiredArgsConstructor;
import org.bs.oms.dto.requestDTO.ParkingRequestDTO;
import org.bs.oms.dto.responseDTO.ParkingResponseDTO;
import org.bs.oms.services.interfaces.ParkingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/parking")
public class ParkingController {

    private final ParkingService parkingService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<ParkingResponseDTO>> parkingList(){
        return new ResponseEntity<>(parkingService.getAllParking(), HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<ParkingResponseDTO> saveParking(@RequestBody ParkingRequestDTO parkingRequestDTO){
        return new ResponseEntity<>(parkingService.addParking(parkingRequestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParkingResponseDTO> updateParking(@RequestBody ParkingRequestDTO parkingRequestDTO, @PathVariable Long id){
        return new ResponseEntity<>(parkingService.updateParking(parkingRequestDTO, id), HttpStatus.ACCEPTED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ParkingResponseDTO> getParking(@PathVariable Long id){
        return new ResponseEntity<>(parkingService.parkingById(id), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteParking(@PathVariable Long id){
        parkingService.deleteParkingById(id);
        return ResponseEntity.noContent().build();
    }
}
