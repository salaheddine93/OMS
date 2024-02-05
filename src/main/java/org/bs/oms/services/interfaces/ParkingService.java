package org.bs.oms.services.interfaces;

import org.bs.oms.dto.requestDTO.ParkingRequestDTO;
import org.bs.oms.dto.responseDTO.ParkingResponseDTO;

import java.util.List;

public interface ParkingService {

    ParkingResponseDTO addParking(ParkingRequestDTO parkingRequestDTO);
    ParkingResponseDTO parkingById(Long id);
    List<ParkingResponseDTO> getAllParking();

    ParkingResponseDTO updateParking(ParkingRequestDTO parkingRequestDTO, Long id);
    void deleteParkingById(Long id);
}
