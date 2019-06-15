package ch.happy.cyclist.service;

import ch.happy.cyclist.model.BestellPosition;
import ch.happy.cyclist.repository.BestellPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

/**
 * Service Klasse zur verwaltung von Bestellpositionen
 */
@Service
public class BestellPositionService {

    @Autowired
    BestellPositionRepository bestellPositionRepository;

    /**
     * Einzelne Bestellposition speichern
     * @param bestellPosition
     */
    public void savePos(@Valid BestellPosition bestellPosition) {
        bestellPositionRepository.saveAndFlush(bestellPosition);
    }

    /**
     * Alle Bestellpositionen holen
     * @return Liste von allen Bestellpositionen
     */
    public List<BestellPosition> getAll() {
        return bestellPositionRepository.findAll();
    }

    /**
     * Liste von Bestellpositionen speichern
     * @param bestellPositionen
     */
    public void saveAll(List<BestellPosition> bestellPositionen) {
        bestellPositionRepository.saveAll(bestellPositionen);
    }

}
