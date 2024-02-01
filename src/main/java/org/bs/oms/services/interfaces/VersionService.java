package org.bs.oms.services.interfaces;

import org.bs.oms.dto.requestDto.VersionRequestDto;
import org.bs.oms.dto.responseDto.VersionResponseDto;
import org.bs.oms.entities.Version;

import java.util.List;

public interface VersionService {

    VersionResponseDto addVersion(VersionRequestDto versionRequestDto);
    VersionResponseDto versionById(Long id);

    VersionResponseDto updateVersion(VersionRequestDto versionRequestDto, Long id);
    List<VersionResponseDto> getAllVersions();
    void deleteVersionById(Long id);
}
