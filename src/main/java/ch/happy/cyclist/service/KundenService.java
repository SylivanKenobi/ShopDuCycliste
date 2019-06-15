package ch.happy.cyclist.service;

import ch.happy.cyclist.model.Kunde;
import ch.happy.cyclist.repository.KundenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

/**
 * Klasse zum verwalten von Kunden
 */
@Service
public class KundenService {

    @Autowired
    KundenRepository kundenRepository;

    /**
     * Kunde speichern
     * @param kunde
     */
    public void saveKunde(@Valid Kunde kunde) {
        kundenRepository.saveAndFlush(kunde);
    }

    /**
     * Kunde löschen
     * @param id
     */
    public void deleteKunde(Long id) {
        kundenRepository.deleteById(id);
    }

    /**
     * Kunde mit id finden
     * @param id
     * @return Kunde
     */
    public Kunde getKunde(Long id) {
        return kundenRepository.findById(id).get();
    }

    /**
     * Alle Kunden finden
     * @return list von Kunden
     */
    public List<Kunde> getAllKunden() {
        return kundenRepository.findAll();
    }

}
