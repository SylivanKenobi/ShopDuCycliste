package ch.happy.writer.service;

import ch.happy.writer.model.Bestellung;
import ch.happy.writer.repository.BestellungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class BestellungService {

    @Autowired
    BestellungRepository bestellungRepository;

    public void saveBestellung(@Valid Bestellung bestellung) {
        bestellungRepository.saveAndFlush(bestellung);
    }
}
