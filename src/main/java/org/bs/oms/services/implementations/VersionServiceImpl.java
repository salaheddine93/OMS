package org.bs.oms.services.implementations;

import lombok.RequiredArgsConstructor;
import org.bs.oms.dto.requestDTO.VersionRequestDTO;
import org.bs.oms.dto.responseDTO.VersionResponseDTO;
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
    public VersionResponseDTO addVersion(VersionRequestDTO versionRequestDTO) {
        Version version = modelMapper.map(versionRequestDTO, Version.class);
        Version savedVersion = versionRepo.save(version);
        return modelMapper.map(savedVersion, VersionResponseDTO.class);
    }

    @Override
    public VersionResponseDTO versionById(Long id) {
        Version version = versionRepo.findById(id).orElseThrow(()-> new RuntimeException("Version not found !!!"));
        return modelMapper.map(version, VersionResponseDTO.class);
    }

    @Override
    public VersionResponseDTO updateVersion(VersionRequestDTO versionRequestDTO, Long id) {
        Optional<Version> versionOptional = versionRepo.findById(id);
        if (versionOptional.isPresent()){
            Version version = modelMapper.map(versionRequestDTO, Version.class);
            version.setId(id);
            Version savedVersion = versionRepo.save(version);
            return modelMapper.map(savedVersion, VersionResponseDTO.class);
        }else {
            throw new RuntimeException("Version not found !!!");
        }
    }

    @Override
    public List<VersionResponseDTO> getAllVersions() {
        return versionRepo.findAll()
                .stream().map(item -> modelMapper.map(item, VersionResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public String deleteVersionById(Long id) {
        Optional<Version> versionOptional = versionRepo.findById(id);
        if (versionOptional.isPresent()){
            Version version = modelMapper.map(versionOptional, Version.class);
            versionRepo.delete(version);
            return "Version : " + id + "has been deleted successfully ";
        }else {
            throw new RuntimeException("Version : " + id + " not found !!!");
        }
    }
}