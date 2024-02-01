package org.bs.oms.services.implementations;

import lombok.RequiredArgsConstructor;
import org.bs.oms.dto.requestDto.VersionRequestDto;
import org.bs.oms.dto.responseDto.VersionResponseDto;
import org.bs.oms.entities.Version;
import org.bs.oms.repositories.VersionRepo;
import org.bs.oms.services.interfaces.VersionService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VersionServiceImpl implements VersionService {

    private final VersionRepo versionRepo;
    private final ModelMapper modelMapper;

    @Override
    public VersionResponseDto addVersion(VersionRequestDto versionRequestDto) {
        Version version = modelMapper.map(versionRequestDto, Version.class);
        Version savedVersion = versionRepo.save(version);
        return modelMapper.map(savedVersion, VersionResponseDto.class);
    }

    @Override
    public VersionResponseDto versionById(Long id) {
        Version version = versionRepo.findById(id).orElseThrow(()-> new RuntimeException("Version not found !!!"));
        return modelMapper.map(version, VersionResponseDto.class);
    }

    @Override
    public VersionResponseDto updateVersion(VersionRequestDto versionRequestDto, Long id) {
        Optional<Version> versionOptional = versionRepo.findById(id);
        if (versionOptional.isPresent()){
            Version version = modelMapper.map(versionRequestDto, Version.class);
            version.setId(id);
            Version savedVersion = versionRepo.save(version);
            return modelMapper.map(savedVersion, VersionResponseDto.class);
        }else {
            throw new RuntimeException("Version not found !!!");
        }
    }

    @Override
    public List<VersionResponseDto> getAllVersions() {
        return versionRepo.findAll()
                .stream().map(item -> modelMapper.map(item, VersionResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteVersionById(Long id) {
        versionRepo.deleteById(id);
    }
}
