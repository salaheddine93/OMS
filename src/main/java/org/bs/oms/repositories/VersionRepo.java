package org.bs.oms.repositories;

import org.bs.oms.entities.Version;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VersionRepo extends JpaRepository<Version, Long> {
    List<Version> findByVersionContaining(String kw);
}
