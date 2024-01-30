package org.bs.oms.services.interfaces;

import org.bs.oms.entities.Squadron;

import java.util.List;

public interface SquadronService {

    Squadron addSquadron(Squadron squadron);
    Squadron squadronById(Long id);
    List<Squadron> getAllSquadrons();
    void deleteSquadronById(Long id);
}
