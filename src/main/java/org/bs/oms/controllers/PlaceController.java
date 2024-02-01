package org.bs.oms.controllers;

import lombok.RequiredArgsConstructor;
import org.bs.oms.dto.requestDto.AirbaseRequestDto;
import org.bs.oms.dto.requestDto.PlaceRequestDto;
import org.bs.oms.dto.responseDto.AirbaseResponseDto;
import org.bs.oms.dto.responseDto.PlaceResponseDto;
import org.bs.oms.entities.Place;
import org.bs.oms.services.interfaces.PlaceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceService placeService;

    @GetMapping(path = "/places")
    public List<PlaceResponseDto> placesList(){
        return placeService.getAllPlaces();
    }

    @PostMapping(path = "/addPlace")
    public PlaceResponseDto savePlace(@RequestBody PlaceRequestDto placeRequestDto){
        return placeService.addPlace(placeRequestDto);
    }

    @PutMapping(path = "/places/{id}")
    public PlaceResponseDto updatePlace(@RequestBody PlaceRequestDto placeRequestDto, @PathVariable Long id) {
        return placeService.updatePlace(placeRequestDto, id);
    }

    @GetMapping(path = "/places/{id}")
    public PlaceResponseDto getPlace(@PathVariable Long id){
        return placeService.placeById(id);
    }

    @DeleteMapping(path = "/places/{id}")
    public void deletePlace(@PathVariable Long id){
        placeService.deletePlaceById(id);
    }
}