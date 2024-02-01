package org.bs.oms.services.implementations;

import lombok.RequiredArgsConstructor;
import org.bs.oms.dto.requestDto.AirbaseRequestDto;
import org.bs.oms.dto.responseDto.AirbaseResponseDto;
import org.bs.oms.entities.Airbase;
import org.bs.oms.repositories.AirbaseRepo;
import org.bs.oms.services.interfaces.AirbaseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<AirbaseResponseDto> getAllAirbases() {
        return airbaseRepo.findAll()
                .stream().map(item -> modelMapper.map(item, AirbaseResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public AirbaseResponseDto updateAirbase(AirbaseRequestDto airbaseRequestDto, Long id) {
        Optional<Airbase> airbaseOptional = airbaseRepo.findById(id);
        if (airbaseOptional.isPresent()){
            Airbase airbase = modelMapper.map(airbaseRequestDto, Airbase.class);
            airbase.setId(id);
            Airbase updatedAirbase = airbaseRepo.save(airbase);
            return modelMapper.map(updatedAirbase, AirbaseResponseDto.class);
        }else {
            throw new RuntimeException("Airbase not found !!!");
        }
    }

    @Override
    public void deleteAirbaseById(Long id) {
        airbaseRepo.deleteById(id);
//        Airbase airbase = airbaseRepo.findById(id).get();
//        airbaseRepo.delete(airbase);
    }
}
