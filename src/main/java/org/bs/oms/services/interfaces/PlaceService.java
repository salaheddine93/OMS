package org.bs.oms.services.interfaces;

import org.bs.oms.entities.Place;

import java.util.List;

public interface PlaceService {

    Place addPlace(Place place);
    Place placeById(Long id);
    List<Place> getAllPlaces();
    void deletePlaceById(Long id);
}
