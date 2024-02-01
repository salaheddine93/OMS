package org.bs.oms.services.interfaces;

import org.bs.oms.dto.requestDto.SquadronRequestDto;
import org.bs.oms.dto.responseDto.SquadronResponseDto;
import org.bs.oms.entities.Squadron;

import java.util.List;

public interface SquadronService {

    SquadronResponseDto addSquadron(SquadronRequestDto squadronRequestDto);
    SquadronResponseDto squadronById(Long id);
    List<SquadronResponseDto> getAllSquadrons();

    SquadronResponseDto updateSquadron(SquadronRequestDto squadronRequestDto, Long id);
    void deleteSquadronById(Long id);
}
