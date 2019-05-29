package ch.happy.writer.service;

import ch.happy.writer.model.Artikel;
import ch.happy.writer.repository.ArtikelRepository;
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
