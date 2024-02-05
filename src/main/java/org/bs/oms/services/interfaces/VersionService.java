package org.bs.oms.services.interfaces;

import org.bs.oms.dto.requestDTO.VersionRequestDTO;
import org.bs.oms.dto.responseDTO.VersionResponseDTO;

import java.util.List;

public interface VersionService {

    VersionResponseDTO addVersion(VersionRequestDTO versionRequestDTO);
    VersionResponseDTO versionById(Long id);

    VersionResponseDTO updateVersion(VersionRequestDTO versionRequestDTO, Long id);
    List<VersionResponseDTO> getAllVersions();
    String deleteVersionById(Long id);
}
