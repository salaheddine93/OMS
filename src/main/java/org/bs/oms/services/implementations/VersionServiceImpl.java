package org.bs.oms.services.implementations;

import lombok.RequiredArgsConstructor;
import org.bs.oms.entities.Version;
import org.bs.oms.repositories.VersionRepo;
import org.bs.oms.services.interfaces.VersionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VersionServiceImpl implements VersionService {

    private final VersionRepo versionRepo;

    @Override
    public Version addVersion(Version version) {
        return versionRepo.save(version);
    }

    @Override
    public Version versionById(Long id) {
        return versionRepo.findById(id).get();
    }

    @Override
    public List<Version> getAllVersions() {
        return versionRepo.findAll();
    }

    @Override
    public void deleteVersionById(Long id) {
        versionRepo.deleteById(id);
    }
}
