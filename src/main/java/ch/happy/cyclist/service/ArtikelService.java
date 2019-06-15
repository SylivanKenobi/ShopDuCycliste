package ch.happy.cyclist.service;

import ch.happy.cyclist.model.Artikel;
import ch.happy.cyclist.repository.ArtikelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasse ArtikelService
 */
@Service
public class ArtikelService {

    @Autowired
    private ArtikelRepository artikelRepository;

    /**
     * Alle Artikel aus der Datenbank auslesen
     * @return Liste von Artikeln
     */
    public List<Artikel> getAllArtikel() {
        return artikelRepository.findAll();
    }

    /**
     * Alle aktiven Artikel aus der Datenbank auslesen
     * @return Liste von Artikeln
     */
    public List<Artikel> getAllArtikelAktiv() {
        List<Artikel> sortedArtikel =  new ArrayList<>();
        List<Artikel> artikelList = artikelRepository.findAll();
        for(Artikel artikel: artikelList){
            if(artikel.getAktiv() == 1){
                sortedArtikel.add(artikel);
            }
        }
        return sortedArtikel;
    }

    /**
     * Artikel mit ID finden
     * @param id
     * @return Artikel
     */
    public Artikel getArtikel(Long id) {
        return artikelRepository.findById(id).get();
    }

    /**
     * Artikel mit ID löschen
     * @param id
     */
    public void deleteArtikel(Long id) {
        artikelRepository.deleteById(id);
    }

    /**
     * Ganze Liste von Artikel auf Inaktiv setzen
     * @param artikelListId
     */
    public void deleteArtikelList(List<Long> artikelListId) {
        for (Long id : artikelListId) {
            Artikel artikel = artikelRepository.findById(id).get();
            System.out.println(artikel.getAktiv());
            artikel.setAktiv(0);
            artikel.setModel(artikel.getModel());
            artikel.setPreis(artikel.getPreis());
            System.out.println(artikel.getAktiv());
            artikelRepository.saveAndFlush(artikel);
        }
    }

    /**
     * Neuen Artikel speichern
     * @param artikel
     */
    public void saveArtikel(Artikel artikel) {
        artikelRepository.saveAndFlush(artikel);
    }
}
