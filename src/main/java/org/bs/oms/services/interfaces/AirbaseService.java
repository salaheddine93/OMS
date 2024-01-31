package org.bs.oms.services.interfaces;

import org.bs.oms.dto.AirbaseRequestDto;
import org.bs.oms.dto.AirbaseResponseDto;
import org.bs.oms.entities.Airbase;
import org.bs.oms.exceptions.AirbaseNotFoundException;

import java.util.List;

public interface AirbaseService {
    AirbaseResponseDto addAirbase(AirbaseRequestDto airbaseRequestDto);
    AirbaseResponseDto airbaseById(Long id) throws AirbaseNotFoundException;
    List<Airbase> getAllAirbases();

    AirbaseResponseDto updateAirbase(AirbaseRequestDto airbaseRequestDto, Long id);
    void deleteAirbaseById(Long id);
}
