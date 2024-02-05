package org.bs.oms.services.implementations;

import lombok.RequiredArgsConstructor;
import org.bs.oms.dto.requestDTO.AircraftMakerRequestDTO;
import org.bs.oms.dto.responseDTO.AircraftMakerResponseDTO;
import org.bs.oms.entities.AircraftMaker;
import org.bs.oms.exceptions.ApiRequestException;
import org.bs.oms.repositories.AircraftMakerRepo;
import org.bs.oms.services.interfaces.AircraftMakerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AircraftMakerServiceImpl implements AircraftMakerService {


    private final AircraftMakerRepo aircraftMakerRepo;
    private final ModelMapper modelMapper;


    @Override
    public AircraftMakerResponseDTO addAircraftMaker(AircraftMakerRequestDTO aircraftMakerRequestDTO) {
        AircraftMaker aircraftMaker = modelMapper.map(aircraftMakerRequestDTO, AircraftMaker.class);
        AircraftMaker savedAircraftMaker = aircraftMakerRepo.save(aircraftMaker);
        return modelMapper.map(savedAircraftMaker, AircraftMakerResponseDTO.class);
    }

    @Override
    public AircraftMakerResponseDTO aircraftMakerById(Long id) {
        AircraftMaker aircraftMaker = aircraftMakerRepo.findById(id).orElseThrow(()-> new ApiRequestException("AircraftMaker : " + id +" not found"));
        return modelMapper.map(aircraftMaker, AircraftMakerResponseDTO.class);
    }

    @Override
    public List<AircraftMakerResponseDTO> getAllAircraftMakers() {
        return aircraftMakerRepo.findAll()
                .stream().map(item-> modelMapper.map(item, AircraftMakerResponseDTO.class))
                .collect(Collectors.toList());

    }

    @Override
    public String deleteAircraftMakerById(Long id) {
        Optional<AircraftMaker> aircraftMakerOptional = aircraftMakerRepo.findById(id);
        if (aircraftMakerOptional.isPresent()){
            AircraftMaker aircraftMaker = modelMapper.map(aircraftMakerOptional, AircraftMaker.class);
            aircraftMakerRepo.delete(aircraftMaker);
            return "AircraftMaker : " + id + "has been successfully deleted";
        }else {
            throw new RuntimeException("AircraftMaker : " + id + "not found");
        }
    }
}