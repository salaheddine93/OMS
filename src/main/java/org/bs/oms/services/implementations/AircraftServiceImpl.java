package org.bs.oms.services.implementations;

import lombok.RequiredArgsConstructor;
import org.bs.oms.dto.requestDTO.AircraftRequestDTO;
import org.bs.oms.dto.responseDTO.AircraftResponseDTO;
import org.bs.oms.entities.Aircraft;
import org.bs.oms.repositories.AircraftRepo;
import org.bs.oms.services.interfaces.AircraftService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AircraftServiceImpl implements AircraftService {

    private final AircraftRepo aircraftRepo;
    private final ModelMapper modelMapper;

    @Override
    public AircraftResponseDTO addAircraft(AircraftRequestDTO aircraftRequestDTO) {
        Aircraft aircraft = modelMapper.map(aircraftRequestDTO, Aircraft.class);
        Aircraft savedAircraft = aircraftRepo.save(aircraft);
        return  modelMapper.map(savedAircraft, AircraftResponseDTO.class);
    }

    @Override
    public AircraftResponseDTO aircraftById(Long id) {
        Aircraft aircraft = aircraftRepo.findById(id).orElseThrow(()-> new RuntimeException("Aircraft not found"));
        return modelMapper.map(aircraft, AircraftResponseDTO.class);
    }

    @Override
    public List<AircraftResponseDTO> getAllAircrafts() {
        return aircraftRepo.findAll()
                .stream().map(item-> modelMapper.map(item, AircraftResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public AircraftResponseDTO updateAircraft(AircraftRequestDTO aircraftRequestDTO, Long id) {
        Optional<Aircraft> aircraftOptional = aircraftRepo.findById(id);
        if (aircraftOptional.isPresent()){
            Aircraft aircraft = modelMapper.map(aircraftRequestDTO, Aircraft.class);
            aircraft.setId(id);
            Aircraft updatedAircraft = aircraftRepo.save(aircraft);
            return modelMapper.map(updatedAircraft, AircraftResponseDTO.class);
        }else {
            throw new RuntimeException("Aircraft not found !!!");
        }
    }

    @Override
    public void deleteAircraftById(Long id) {
        aircraftRepo.deleteById(id);
    }
}
