package org.bs.oms.services.interfaces;

import org.bs.oms.dto.requestDto.ParkingRequestDto;
import org.bs.oms.dto.responseDto.ParkingResponseDto;
import org.bs.oms.entities.Parking;

import java.util.List;

public interface ParkingService {

    ParkingResponseDto addParking(ParkingRequestDto parkingRequestDto);
    ParkingResponseDto parkingById(Long id);
    List<ParkingResponseDto> getAllParking();

    ParkingResponseDto updateParking(ParkingRequestDto parkingRequestDto, Long id);
    void deleteParkingById(Long id);
}
