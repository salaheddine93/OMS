package org.bs.oms.services.implementations;

import lombok.RequiredArgsConstructor;
import org.bs.oms.entities.Place;
import org.bs.oms.repositories.PlaceRepo;
import org.bs.oms.services.interfaces.PlaceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaceServiceImpl implements PlaceService {

    private final PlaceRepo placeRepo;

    @Override
    public Place addPlace(Place place) {
        return placeRepo.save(place);
    }

    @Override
    public Place placeById(Long id) {
        return placeRepo.findById(id).get();
    }

    @Override
    public List<Place> getAllPlaces() {
        return placeRepo.findAll();
    }

    @Override
    public void deletePlaceById(Long id) {
        placeRepo.deleteById(id);
    }
}
