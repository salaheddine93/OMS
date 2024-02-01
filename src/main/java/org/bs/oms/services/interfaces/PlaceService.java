package org.bs.oms.services.interfaces;

import org.bs.oms.dto.requestDto.PlaceRequestDto;
import org.bs.oms.dto.responseDto.PlaceResponseDto;

import java.util.List;

public interface PlaceService {

    PlaceResponseDto addPlace(PlaceRequestDto placeRequestDto);
    PlaceResponseDto placeById(Long id);
    List<PlaceResponseDto> getAllPlaces();
    PlaceResponseDto updatePlace(PlaceRequestDto placeRequestDto, Long id);
    void deletePlaceById(Long id);
}
