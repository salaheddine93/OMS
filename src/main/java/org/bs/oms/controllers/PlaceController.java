package org.bs.oms.controllers;

import lombok.RequiredArgsConstructor;
import org.bs.oms.dto.requestDTO.PlaceRequestDTO;
import org.bs.oms.dto.responseDTO.PlaceResponseDTO;
import org.bs.oms.services.interfaces.PlaceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/places")
public class PlaceController {

    private final PlaceService placeService;

    @GetMapping(path = "/all")
    public List<PlaceResponseDTO> placesList(){
        return placeService.getAllPlaces();
    }

    @PostMapping(path = "/add")
    public PlaceResponseDTO savePlace(@RequestBody PlaceRequestDTO placeRequestDTO){
        return placeService.addPlace(placeRequestDTO);
    }

    @PutMapping(path = "/{id}")
    public PlaceResponseDTO updatePlace(@RequestBody PlaceRequestDTO placeRequestDTO, @PathVariable Long id) {
        return placeService.updatePlace(placeRequestDTO, id);
    }

    @GetMapping(path = "/{id}")
    public PlaceResponseDTO getPlace(@PathVariable Long id){
        return placeService.placeById(id);
    }

    @DeleteMapping(path = "/{id}")
    public void deletePlace(@PathVariable Long id){
        placeService.deletePlaceById(id);
    }
}