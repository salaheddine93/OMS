package org.bs.oms.services.interfaces;

import org.bs.oms.dto.requestDto.AircraftRequestDto;
import org.bs.oms.dto.responseDto.AircraftResponseDto;
import org.bs.oms.entities.Aircraft;

import java.util.List;

public interface AircraftService {

    AircraftResponseDto addAircraft(AircraftRequestDto aircraftRequestDto);
    AircraftResponseDto aircraftById(Long id);
    List<AircraftResponseDto> getAllAircrafts();
    AircraftResponseDto updateAircraft(AircraftRequestDto aircraftRequestDto, Long id);
    void deleteAircraftById(Long id);
}
