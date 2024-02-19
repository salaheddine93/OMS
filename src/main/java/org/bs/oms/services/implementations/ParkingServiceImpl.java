package org.bs.oms.services.implementations;

import lombok.RequiredArgsConstructor;
import org.bs.oms.dto.requestDTO.ParkingRequestDTO;
import org.bs.oms.dto.responseDTO.ParkingResponseDTO;
import org.bs.oms.entities.Parking;
import org.bs.oms.repositories.AirbaseRepo;
import org.bs.oms.repositories.ParkingRepo;
import org.bs.oms.services.interfaces.ParkingService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ParkingServiceImpl implements ParkingService {

    private final ParkingRepo parkingRepo;
    private final AirbaseRepo airbaseRepo;
    private final ModelMapper modelMapper;

    @Override
    public ParkingResponseDTO addParking(ParkingRequestDTO parkingRequestDTO) {
        Parking parking = modelMapper.map(parkingRequestDTO, Parking.class);
        parking.setAirbase(airbaseRepo.findById(parkingRequestDTO.getAirbaseId()).orElseThrow(()-> new RuntimeException("Airbase not found !!!")));
        Parking savedParking = parkingRepo.save(parking);
        return modelMapper.map(savedParking, ParkingResponseDTO.class);
    }

    @Override
    public ParkingResponseDTO parkingById(Long id) {
        Parking parking = parkingRepo.findById(id).orElseThrow(()-> new RuntimeException("Parking not found !!!"));
        return modelMapper.map(parking, ParkingResponseDTO.class);
    }

    @Override
    public List<ParkingResponseDTO> getAllParking() {
        return parkingRepo.findAll()
                .stream().map(item -> modelMapper.map(item, ParkingResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ParkingResponseDTO updateParking(ParkingRequestDTO parkingRequestDTO, Long id) {
        Optional<Parking> parkingOptional = parkingRepo.findById(id);
        if (parkingOptional.isPresent()) {
            Parking parking = modelMapper.map(parkingRequestDTO, Parking.class);
            parking.setId(id);
            Parking updatedParking = parkingRepo.save(parking);
            return modelMapper.map(updatedParking, ParkingResponseDTO.class);
        }else {
            throw new RuntimeException("Parking not found !!!");
        }
    }

    @Override
    public void deleteParkingById(Long id) {
        parkingRepo.deleteById(id

        );
    }
}
