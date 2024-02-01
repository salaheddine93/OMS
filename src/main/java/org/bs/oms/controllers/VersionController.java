package org.bs.oms.controllers;

import lombok.RequiredArgsConstructor;
import org.bs.oms.dto.requestDto.VersionRequestDto;
import org.bs.oms.dto.responseDto.VersionResponseDto;
import org.bs.oms.entities.Version;
import org.bs.oms.services.interfaces.VersionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class VersionController {

    private final VersionService versionService;

    @GetMapping(path = "/versions")
    public List<VersionResponseDto> versionsList(){
        return versionService.getAllVersions();
    }

    @PostMapping(path = "/addVersion")
    public VersionResponseDto saveVersion(@RequestBody VersionRequestDto versionRequestDto){
        return versionService.addVersion(versionRequestDto);
    }

    @PutMapping("/versions/{id}")
    public VersionResponseDto updateVersion(@RequestBody VersionRequestDto versionRequestDto, @PathVariable Long id){
        return versionService.updateVersion(versionRequestDto, id);
    }

    @GetMapping(path = "/versions/{id}")
    public VersionResponseDto getVersion(@PathVariable Long id){
        return versionService.versionById(id);
    }

    @DeleteMapping(path = "/versions/{id}")
    public void deleteVersion(@PathVariable Long id){
        versionService.deleteVersionById(id);
    }
}
