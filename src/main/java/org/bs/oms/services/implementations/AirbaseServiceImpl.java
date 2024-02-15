package org.bs.oms.services.implementations;

import lombok.RequiredArgsConstructor;
import org.bs.oms.dto.requestDTO.AirbaseRequestDTO;
import org.bs.oms.dto.responseDTO.AirbaseResponseDTO;
import org.bs.oms.entities.Airbase;
import org.bs.oms.exceptions.ApiRequestException;
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
    public AirbaseResponseDTO addAirbase(AirbaseRequestDTO airbaseRequestDTO) {
        Airbase airbase = modelMapper.map(airbaseRequestDTO, Airbase.class);
        airbase.setSurface(airbaseRequestDTO.getSurface()+" Ha");
        Airbase savedAirbase = airbaseRepo.save(airbase);
        return modelMapper.map(savedAirbase, AirbaseResponseDTO.class);
    }

    @Override
    public AirbaseResponseDTO airbaseById(Long id) {
        Airbase airbase = airbaseRepo.findById(id).orElseThrow(()-> new ApiRequestException("Airbase : " + id + " not found"));
        return modelMapper.map(airbase, AirbaseResponseDTO.class);
    }

    @Override
    public List<AirbaseResponseDTO> getAllAirbases() {
        return airbaseRepo.findAll()
                .stream().map(item -> modelMapper.map(item, AirbaseResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public AirbaseResponseDTO updateAirbase(AirbaseRequestDTO airbaseRequestDTO, Long id) {
        Optional<Airbase> airbaseOptional = airbaseRepo.findById(id);
        if (airbaseOptional.isPresent()){
            Airbase airbase = modelMapper.map(airbaseRequestDTO, Airbase.class);
            airbase.setId(id);
            Airbase updatedAirbase = airbaseRepo.save(airbase);
            return modelMapper.map(updatedAirbase, AirbaseResponseDTO.class);
        }else {
            throw new RuntimeException("Airbase : " + id + " not found");
        }
    }

    @Override
    public String deleteAirbaseById(Long id) {
        Optional<Airbase> airbaseOptional = airbaseRepo.findById(id);
        if (airbaseOptional.isPresent()){
            Airbase airbase = modelMapper.map(airbaseOptional, Airbase.class);
            airbaseRepo.delete(airbase);
            return "Airbase : "+id+" has been deleted successfully";
        }else {
            throw new ApiRequestException("Airbase : " + id + " not found");
        }
    }
}
