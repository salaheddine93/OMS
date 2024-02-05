package org.bs.oms.services.implementations;

import lombok.RequiredArgsConstructor;
import org.bs.oms.dto.requestDTO.PlaceRequestDTO;
import org.bs.oms.dto.responseDTO.PlaceResponseDTO;
import org.bs.oms.entities.Place;
import org.bs.oms.repositories.PlaceRepo;
import org.bs.oms.services.interfaces.PlaceService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlaceServiceImpl implements PlaceService {

    private final PlaceRepo placeRepo;
    private final ModelMapper modelMapper;

    @Override
    public PlaceResponseDTO addPlace(PlaceRequestDTO placeRequestDTO) {
        Place place = modelMapper.map(placeRequestDTO, Place.class);
        Place savedPlace = placeRepo.save(place);
        return modelMapper.map(savedPlace, PlaceResponseDTO.class);
    }

    @Override
    public PlaceResponseDTO placeById(Long id) {
        Place place = placeRepo.findById(id).orElseThrow(()-> new RuntimeException("place not found !!!"));
        return modelMapper.map(place, PlaceResponseDTO.class);
    }

    @Override
    public List<PlaceResponseDTO> getAllPlaces() {
        return placeRepo.findAll()
                .stream().map(item -> modelMapper.map(item, PlaceResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PlaceResponseDTO updatePlace(PlaceRequestDTO placeRequestDTO, Long id) {
        Optional<Place> placeOptional = placeRepo.findById(id);
        if (placeOptional.isPresent()){
            Place place = modelMapper.map(placeRequestDTO, Place.class);
            place.setId(id);
            Place savedPlace = placeRepo.save(place);
            return modelMapper.map(savedPlace, PlaceResponseDTO.class);
        }else {
            throw new RuntimeException("Place not found !!!");
        }
    }

    @Override
    public void deletePlaceById(Long id) {
        placeRepo.deleteById(id);
    }
}
