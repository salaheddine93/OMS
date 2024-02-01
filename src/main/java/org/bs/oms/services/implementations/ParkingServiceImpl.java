package org.bs.oms.services.implementations;

import lombok.RequiredArgsConstructor;
import org.bs.oms.dto.requestDto.ParkingRequestDto;
import org.bs.oms.dto.responseDto.ParkingResponseDto;
import org.bs.oms.entities.Parking;
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
    private final ModelMapper modelMapper;

    @Override
    public ParkingResponseDto addParking(ParkingRequestDto parkingRequestDto) {
        Parking parking = modelMapper.map(parkingRequestDto, Parking.class);
        Parking savedParking = parkingRepo.save(parking);
        return modelMapper.map(savedParking, ParkingResponseDto.class);
    }

    @Override
    public ParkingResponseDto parkingById(Long id) {
        Parking parking = parkingRepo.findById(id).orElseThrow(()-> new RuntimeException("Parking not found !!!"));
        return modelMapper.map(parking, ParkingResponseDto.class);
    }

    @Override
    public List<ParkingResponseDto> getAllParking() {
        return parkingRepo.findAll()
                .stream().map(item -> modelMapper.map(item, ParkingResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ParkingResponseDto updateParking(ParkingRequestDto parkingRequestDto, Long id) {
        Optional<Parking> parkingOptional = parkingRepo.findById(id);
        if (parkingOptional.isPresent()) {
            Parking parking = modelMapper.map(parkingRequestDto, Parking.class);
            parking.setId(id);
            Parking updatedParking = parkingRepo.save(parking);
            return modelMapper.map(updatedParking, ParkingResponseDto.class);
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
