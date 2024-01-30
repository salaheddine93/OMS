package org.bs.oms.controllers;

import lombok.RequiredArgsConstructor;
import org.bs.oms.entities.Version;
import org.bs.oms.services.interfaces.VersionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class VersionController {

    private final VersionService versionService;

    @GetMapping(path = "/versions")
    public List<Version> versionsList(){
        return versionService.getAllVersions();
    }

    @PostMapping(path = "/addVersion")
    public Version saveVersion(@RequestBody Version version){
        return versionService.addVersion(version);
    }

    @GetMapping(path = "/versions/{id}")
    public Version getVersion(@PathVariable Long id){
        return versionService.versionById(id);
    }

    @DeleteMapping(path = "/versions/{id}")
    public void deleteVersion(@PathVariable Long id){
        versionService.deleteVersionById(id);
    }
}
