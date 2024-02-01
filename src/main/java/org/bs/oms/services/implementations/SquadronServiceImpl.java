package org.bs.oms.services.implementations;

import lombok.RequiredArgsConstructor;
import org.bs.oms.dto.requestDto.SquadronRequestDto;
import org.bs.oms.dto.responseDto.SquadronResponseDto;
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
    public SquadronResponseDto addSquadron(SquadronRequestDto squadronRequestDto) {
        Squadron squadron = modelMapper.map(squadronRequestDto, Squadron.class);
        Squadron savedSquadron = squadronRepo.save(squadron);
        return modelMapper.map(savedSquadron, SquadronResponseDto.class);
    }

    @Override
    public SquadronResponseDto squadronById(Long id) {
        Squadron squadron = squadronRepo.findById(id).orElseThrow(()-> new RuntimeException("Squadron not found !!!"));
        return modelMapper.map(squadron, SquadronResponseDto.class);
    }

    @Override
    public List<SquadronResponseDto> getAllSquadrons() {
        return squadronRepo.findAll()
                .stream().map(item -> modelMapper.map(item, SquadronResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public SquadronResponseDto updateSquadron(SquadronRequestDto squadronRequestDto, Long id) {
        Optional<Squadron> squadronOptional = squadronRepo.findById(id);
        if (squadronOptional.isPresent()){
            Squadron squadron = modelMapper.map(squadronRequestDto, Squadron.class);
            squadron.setId(id);
            Squadron updatedSquadron = squadronRepo.save(squadron);
            return modelMapper.map(updatedSquadron, SquadronResponseDto.class);
        }else {
            throw new RuntimeException("Squadron not found !!!");
        }
    }

    @Override
    public void deleteSquadronById(Long id) {
        squadronRepo.deleteById(id);
    }
}
