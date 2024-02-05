package org.bs.oms.services.interfaces;

import org.bs.oms.dto.requestDTO.SquadronRequestDTO;
import org.bs.oms.dto.responseDTO.SquadronResponseDTO;

import java.util.List;

public interface SquadronService {

    SquadronResponseDTO addSquadron(SquadronRequestDTO squadronRequestDTO);
    SquadronResponseDTO squadronById(Long id);
    List<SquadronResponseDTO> getAllSquadrons();

    SquadronResponseDTO updateSquadron(SquadronRequestDTO squadronRequestDTO, Long id);
    void deleteSquadronById(Long id);
}
