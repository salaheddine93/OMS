package org.bs.oms.services.implementations;

import lombok.RequiredArgsConstructor;
import org.bs.oms.dto.requestDto.AircraftRequestDto;
import org.bs.oms.dto.responseDto.AircraftResponseDto;
import org.bs.oms.entities.Aircraft;
import org.bs.oms.repositories.AircraftRepo;
import org.bs.oms.services.interfaces.AircraftService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AircraftServiceImpl implements AircraftService {

    private final AircraftRepo aircraftRepo;
    private final ModelMapper modelMapper;

    @Override
    public AircraftResponseDto addAircraft(AircraftRequestDto aircraftRequestDto) {
        Aircraft aircraft = modelMapper.map(aircraftRequestDto, Aircraft.class);
        Aircraft savedAircraft = aircraftRepo.save(aircraft);
        return  modelMapper.map(savedAircraft, AircraftResponseDto.class);
    }

    @Override
    public AircraftResponseDto aircraftById(Long id) {
        Aircraft aircraft = aircraftRepo.findById(id).orElseThrow(()-> new RuntimeException("Aircraft not found"));
        return modelMapper.map(aircraft, AircraftResponseDto.class);
    }

    @Override
    public List<AircraftResponseDto> getAllAircrafts() {
        return aircraftRepo.findAll()
                .stream().map(item-> modelMapper.map(item, AircraftResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public AircraftResponseDto updateAircraft(AircraftRequestDto aircraftRequestDto, Long id) {
        Optional<Aircraft> aircraftOptional = aircraftRepo.findById(id);
        if (aircraftOptional.isPresent()){
            Aircraft aircraft = modelMapper.map(aircraftRequestDto, Aircraft.class);
            aircraft.setId(id);
            Aircraft updatedAircraft = aircraftRepo.save(aircraft);
            return modelMapper.map(updatedAircraft, AircraftResponseDto.class);
        }else {
            throw new RuntimeException("Aircraft not found !!!");
        }
    }

    @Override
    public void deleteAircraftById(Long id) {
        aircraftRepo.deleteById(id);
    }
}
