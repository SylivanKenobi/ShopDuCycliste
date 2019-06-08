package ch.happy.cyclist.service;

import ch.happy.cyclist.model.Artikel;
import ch.happy.cyclist.repository.ArtikelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtikelService {

    @Autowired
    private ArtikelRepository artikelRepository;

    public List<Artikel> getAllArtikel(){
        return artikelRepository.findAll();
    }

    public Artikel getArtikel(Long id){
        return artikelRepository.findById(id).get();
    }
}
