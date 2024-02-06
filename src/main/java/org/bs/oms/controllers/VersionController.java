package org.bs.oms.controllers;

import lombok.RequiredArgsConstructor;
import org.bs.oms.dto.requestDTO.VersionRequestDTO;
import org.bs.oms.dto.responseDTO.VersionResponseDTO;
import org.bs.oms.services.interfaces.VersionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/versions")
public class VersionController {

    private final VersionService versionService;

    @GetMapping(path = "/all")
    public ResponseEntity<List<VersionResponseDTO>> versionsList(){
        return new ResponseEntity<>(versionService.getAllVersions(), HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<VersionResponseDTO> saveVersion(@RequestBody VersionRequestDTO versionRequestDTO){
        return new ResponseEntity<>(versionService.addVersion(versionRequestDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VersionResponseDTO> updateVersion(@RequestBody VersionRequestDTO versionRequestDTO, @PathVariable Long id){
        return new ResponseEntity<>(versionService.updateVersion(versionRequestDTO, id), HttpStatus.ACCEPTED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<VersionResponseDTO> getVersion(@PathVariable Long id){
        return new ResponseEntity<>(versionService.versionById(id), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteVersion(@PathVariable Long id){
        versionService.deleteVersionById(id);
        return ResponseEntity.noContent().build();
    }
}
