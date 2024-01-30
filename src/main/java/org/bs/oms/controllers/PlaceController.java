package org.bs.oms.controllers;

import lombok.RequiredArgsConstructor;
import org.bs.oms.entities.Place;
import org.bs.oms.services.interfaces.PlaceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceService placeService;

    @GetMapping(path = "/places")
    public List<Place> placesList(){
        return placeService.getAllPlaces();
    }

    @PostMapping(path = "/addPlace")
    public Place savePlace(@RequestBody Place place){
        return placeService.addPlace(place);
    }

    @GetMapping(path = "/places/{id}")
    public Place getPlace(@PathVariable Long id){
        return placeService.placeById(id);
    }

    @DeleteMapping(path = "/places/{id}")
    public void deletePlace(@PathVariable Long id){
        placeService.deletePlaceById(id);
    }
}