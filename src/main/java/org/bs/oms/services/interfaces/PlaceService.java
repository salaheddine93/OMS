package org.bs.oms.services.interfaces;

import org.bs.oms.dto.requestDTO.PlaceRequestDTO;
import org.bs.oms.dto.responseDTO.PlaceResponseDTO;

import java.util.List;

public interface PlaceService {

    PlaceResponseDTO addPlace(PlaceRequestDTO placeRequestDTO);
    PlaceResponseDTO placeById(Long id);
    List<PlaceResponseDTO> getAllPlaces();
    PlaceResponseDTO updatePlace(PlaceRequestDTO placeRequestDTO, Long id);
    void deletePlaceById(Long id);
}
