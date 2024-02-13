package org.bs.oms.services.implementations;

import lombok.RequiredArgsConstructor;
import org.bs.oms.dto.requestDTO.SquadronRequestDTO;
import org.bs.oms.dto.responseDTO.SquadronResponseDTO;
import org.bs.oms.entities.Squadron;
import org.bs.oms.repositories.SquadronRepo;
import org.bs.oms.services.interfaces.SquadronService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SquadronServiceImpl implements SquadronService {

    private final SquadronRepo squadronRepo;
    private final ModelMapper modelMapper;

    @Override
    public SquadronResponseDTO addSquadron(SquadronRequestDTO squadronRequestDTO) {
        Squadron squadron = modelMapper.map(squadronRequestDTO, Squadron.class);
        //affectation.setPosition(positionRepository.findById(dto.getPositionId()).orElseThrow(()->new BadRequestException("position incorrecte")));
        Squadron savedSquadron = squadronRepo.save(squadron);
        return modelMapper.map(savedSquadron, SquadronResponseDTO.class);
    }

    @Override
    public SquadronResponseDTO squadronById(Long id) {
        Squadron squadron = squadronRepo.findById(id).orElseThrow(()-> new RuntimeException("Squadron not found !!!"));
        return modelMapper.map(squadron, SquadronResponseDTO.class);
    }

    @Override
    public List<SquadronResponseDTO> getAllSquadrons() {
        return squadronRepo.findAll()
                .stream().map(item -> modelMapper.map(item, SquadronResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public SquadronResponseDTO updateSquadron(SquadronRequestDTO squadronRequestDTO, Long id) {
        Optional<Squadron> squadronOptional = squadronRepo.findById(id);
        if (squadronOptional.isPresent()){
            Squadron squadron = modelMapper.map(squadronRequestDTO, Squadron.class);
            squadron.setId(id);
            Squadron updatedSquadron = squadronRepo.save(squadron);
            return modelMapper.map(updatedSquadron, SquadronResponseDTO.class);
        }else {
            throw new RuntimeException("Squadron not found !!!");
        }
    }

    @Override
    public void deleteSquadronById(Long id) {
        squadronRepo.deleteById(id);
    }
}
