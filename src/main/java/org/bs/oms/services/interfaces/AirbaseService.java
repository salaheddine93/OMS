package org.bs.oms.services.interfaces;

import org.bs.oms.dto.requestDTO.AirbaseRequestDTO;
import org.bs.oms.dto.responseDTO.AirbaseResponseDTO;

import java.util.List;

public interface AirbaseService {
    AirbaseResponseDTO addAirbase(AirbaseRequestDTO airbaseRequestDTO);
    AirbaseResponseDTO airbaseById(Long id);
    List<AirbaseResponseDTO> getAllAirbases();
    AirbaseResponseDTO updateAirbase(AirbaseRequestDTO airbaseRequestDTO, Long id);
    String deleteAirbaseById(Long id);
}
