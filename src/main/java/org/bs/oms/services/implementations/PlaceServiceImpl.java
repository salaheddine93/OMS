package org.bs.oms.services.implementations;

import lombok.RequiredArgsConstructor;
import org.bs.oms.dto.requestDto.PlaceRequestDto;
import org.bs.oms.dto.responseDto.PlaceResponseDto;
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
    public PlaceResponseDto addPlace(PlaceRequestDto placeRequestDto) {
        Place place = modelMapper.map(placeRequestDto, Place.class);
        Place savedPlace = placeRepo.save(place);
        return modelMapper.map(savedPlace, PlaceResponseDto.class);
    }

    @Override
    public PlaceResponseDto placeById(Long id) {
        Place place = placeRepo.findById(id).orElseThrow(()-> new RuntimeException("place not found !!!"));
        return modelMapper.map(place, PlaceResponseDto.class);
    }

    @Override
    public List<PlaceResponseDto> getAllPlaces() {
        return placeRepo.findAll()
                .stream().map(item -> modelMapper.map(item, PlaceResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PlaceResponseDto updatePlace(PlaceRequestDto placeRequestDto, Long id) {
        Optional<Place> placeOptional = placeRepo.findById(id);
        if (placeOptional.isPresent()){
            Place place = modelMapper.map(placeRequestDto, Place.class);
            place.setId(id);
            Place savedPlace = placeRepo.save(place);
            return modelMapper.map(savedPlace, PlaceResponseDto.class);
        }else {
            throw new RuntimeException("Place not found !!!");
        }
    }

    @Override
    public void deletePlaceById(Long id) {
        placeRepo.deleteById(id);
    }
}
