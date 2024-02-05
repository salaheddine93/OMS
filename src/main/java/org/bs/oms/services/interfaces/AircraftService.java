package org.bs.oms.services.interfaces;

import org.bs.oms.dto.requestDTO.AircraftRequestDTO;
import org.bs.oms.dto.responseDTO.AircraftResponseDTO;

import java.util.List;

public interface AircraftService {

    AircraftResponseDTO addAircraft(AircraftRequestDTO aircraftRequestDTO);
    AircraftResponseDTO aircraftById(Long id);
    List<AircraftResponseDTO> getAllAircrafts();
    AircraftResponseDTO updateAircraft(AircraftRequestDTO aircraftRequestDTO, Long id);
    void deleteAircraftById(Long id);
}
