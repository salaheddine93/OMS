package org.bs.oms.services.interfaces;

import org.bs.oms.dto.requestDTO.AircraftMakerRequestDTO;
import org.bs.oms.dto.responseDTO.AircraftMakerResponseDTO;
import org.bs.oms.entities.AircraftMaker;

import java.util.List;

public interface AircraftMakerService {

    AircraftMakerResponseDTO addAircraftMaker(AircraftMakerRequestDTO aircraftMakerRequestDTO);
    AircraftMakerResponseDTO aircraftMakerById(Long id);
    List<AircraftMakerResponseDTO> getAllAircraftMakers();
    String deleteAircraftMakerById(Long id);
}
