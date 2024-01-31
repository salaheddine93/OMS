package org.bs.oms.services.implementations;

import lombok.RequiredArgsConstructor;
import org.bs.oms.dto.AirbaseRequestDto;
import org.bs.oms.dto.AirbaseResponseDto;
import org.bs.oms.entities.Airbase;
import org.bs.oms.repositories.AirbaseRepo;
import org.bs.oms.services.interfaces.AirbaseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AirbaseServiceImpl implements AirbaseService {

    private final AirbaseRepo airbaseRepo;
    private final ModelMapper modelMapper;

    @Override
    public AirbaseResponseDto addAirbase(AirbaseRequestDto airbaseRequestDto) {
        Airbase airbase = modelMapper.map(airbaseRequestDto, Airbase.class);
        Airbase savedAirbase = airbaseRepo.save(airbase);
        return modelMapper.map(savedAirbase, AirbaseResponseDto.class);
    }

    @Override
    public AirbaseResponseDto airbaseById(Long id) {
        Airbase airbase = airbaseRepo.findById(id).orElseThrow(()-> new RuntimeException("Airbase not found !!!"));
        return modelMapper.map(airbase, AirbaseResponseDto.class);
    }

    @Override
    public List<Airbase> getAllAirbases() {
        List<Airbase> airbases = airbaseRepo.findAll();
        return Collections.singletonList(modelMapper.map(airbases, AirbaseResponseDto.class));
    }

    @Override
    public AirbaseResponseDto updateAirbase(AirbaseRequestDto airbaseRequestDto, Long id) {
        return null;
    }

    @Override
    public void deleteAirbaseById(Long id) {
        airbaseRepo.deleteById(id);
    }
}
