package org.bs.oms.repositories;

import org.bs.oms.entities.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaceRepo extends JpaRepository<Place, Long> {
    List<Place> findByNameContaining(String kw);
}
