package org.bs.oms.services.implementations;

import lombok.RequiredArgsConstructor;
import org.bs.oms.entities.Squadron;
import org.bs.oms.repositories.SquadronRepo;
import org.bs.oms.services.interfaces.SquadronService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SquadronServiceImpl implements SquadronService {

    private final SquadronRepo squadronRepo;

    @Override
    public Squadron addSquadron(Squadron squadron) {
        return squadronRepo.save(squadron);
    }

    @Override
    public Squadron squadronById(Long id) {
        return squadronRepo.findById(id).get();
    }

    @Override
    public List<Squadron> getAllSquadrons() {
        return squadronRepo.findAll();
    }

    @Override
    public void deleteSquadronById(Long id) {
        squadronRepo.deleteById(id);
    }
}
