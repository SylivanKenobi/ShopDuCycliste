package ch.happy.cyclist.service;

import ch.happy.cyclist.model.Artikel;
import ch.happy.cyclist.repository.ArtikelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArtikelService {

    @Autowired
    private ArtikelRepository artikelRepository;

    public List<Artikel> getAllArtikel() {
        return artikelRepository.findAll();
    }

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

    public Artikel getArtikel(Long id) {
        return artikelRepository.findById(id).get();
    }

    public void deleteArtikel(Long id) {
        artikelRepository.deleteById(id);
    }

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

    public void saveArtikel(Artikel artikel) {
        artikelRepository.saveAndFlush(artikel);
    }
}
