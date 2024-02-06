package org.bs.oms.controllers;

import lombok.RequiredArgsConstructor;
import org.bs.oms.dto.requestDTO.PlaceRequestDTO;
import org.bs.oms.dto.responseDTO.PlaceResponseDTO;
import org.bs.oms.services.interfaces.PlaceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/places")
public class PlaceController {

    private final PlaceService placeService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<PlaceResponseDTO>> placesList(){
        return new ResponseEntity<>(placeService.getAllPlaces(), HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<PlaceResponseDTO> savePlace(@RequestBody PlaceRequestDTO placeRequestDTO){
        return new ResponseEntity<>(placeService.addPlace(placeRequestDTO), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<PlaceResponseDTO> updatePlace(@RequestBody PlaceRequestDTO placeRequestDTO, @PathVariable Long id) {
        return new ResponseEntity<>(placeService.updatePlace(placeRequestDTO, id), HttpStatus.ACCEPTED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PlaceResponseDTO> getPlace(@PathVariable Long id){
        return new ResponseEntity<>(placeService.placeById(id), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deletePlace(@PathVariable Long id){
        placeService.deletePlaceById(id);
        return ResponseEntity.noContent().build();
    }
}