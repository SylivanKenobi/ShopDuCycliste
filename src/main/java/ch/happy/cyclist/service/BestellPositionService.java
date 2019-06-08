package ch.happy.cyclist.service;

import ch.happy.cyclist.model.BestellPosition;
import ch.happy.cyclist.repository.BestellPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class BestellPositionService {

    @Autowired
    BestellPositionRepository bestellPositionRepository;

    public void savePos(@Valid BestellPosition bestellPosition){
        bestellPositionRepository.saveAndFlush(bestellPosition);
    }

    public List<BestellPosition> getAll(){
        return bestellPositionRepository.findAll();
    }

}
