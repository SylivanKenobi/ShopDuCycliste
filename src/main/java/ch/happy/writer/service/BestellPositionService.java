package ch.happy.writer.service;

import ch.happy.writer.model.BestellPosition;
import ch.happy.writer.repository.BestellPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class BestellPositionService {

    @Autowired
    BestellPositionRepository bestellPositionRepository;

    public void savePos(@Valid BestellPosition bestellPosition){
        bestellPositionRepository.saveAndFlush(bestellPosition);
    }
}