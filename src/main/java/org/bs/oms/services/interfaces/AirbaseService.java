package org.bs.oms.services.interfaces;

import org.bs.oms.dto.requestDto.AirbaseRequestDto;
import org.bs.oms.dto.responseDto.AirbaseResponseDto;

import java.util.List;

public interface AirbaseService {
    AirbaseResponseDto addAirbase(AirbaseRequestDto airbaseRequestDto);
    AirbaseResponseDto airbaseById(Long id);
    List<AirbaseResponseDto> getAllAirbases();

    AirbaseResponseDto updateAirbase(AirbaseRequestDto airbaseRequestDto, Long id);
    void deleteAirbaseById(Long id);
}
