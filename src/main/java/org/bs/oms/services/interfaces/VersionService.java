package org.bs.oms.services.interfaces;

import org.bs.oms.entities.Version;

import java.util.List;

public interface VersionService {

    Version addVersion(Version version);
    Version versionById(Long id);
    List<Version> getAllVersions();
    void deleteVersionById(Long id);
}
