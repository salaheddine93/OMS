package org.bs.oms.controllers;

import lombok.RequiredArgsConstructor;
import org.bs.oms.dto.requestDTO.VersionRequestDTO;
import org.bs.oms.dto.responseDTO.VersionResponseDTO;
import org.bs.oms.exceptions.ApiRequestException;
import org.bs.oms.services.interfaces.VersionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/versions")
public class VersionController {

    private final VersionService versionService;

    @GetMapping(path = "/all")
    public List<VersionResponseDTO> versionsList(){
        return versionService.getAllVersions();
    }

//    @GetMapping(path = "/all")
//    public List<VersionResponseDTO> versionsList(){
//       throw new ApiRequestException("Exceptions testiong !!!");
//    }

    @PostMapping(path = "/add")
    public VersionResponseDTO saveVersion(@RequestBody VersionRequestDTO versionRequestDTO){
        return versionService.addVersion(versionRequestDTO);
    }

    @PutMapping("/{id}")
    public VersionResponseDTO updateVersion(@RequestBody VersionRequestDTO versionRequestDTO, @PathVariable Long id){
        return versionService.updateVersion(versionRequestDTO, id);
    }

    @GetMapping(path = "/{id}")
    public VersionResponseDTO getVersion(@PathVariable Long id){
        return versionService.versionById(id);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteVersion(@PathVariable Long id){
        versionService.deleteVersionById(id);
    }
}
