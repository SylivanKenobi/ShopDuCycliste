package ch.happy.cyclist.service;

import ch.happy.cyclist.model.Bestellung;
import ch.happy.cyclist.repository.BestellungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

/**
 * Klasse zur Bestellungs verwaltung
 * @author Sylvain Gilgen
 */
@Service
public class BestellungService {

    @Autowired
    BestellungRepository bestellungRepository;

    /**
     * Methode zum speicher einer Bestellung
     * @param bestellung
     */
    public void saveBestellung(@Valid Bestellung bestellung) {
        bestellungRepository.saveAndFlush(bestellung);
    }
}
