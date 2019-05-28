package ch.happy.writer.service;

import ch.happy.writer.model.Kunde;
import ch.happy.writer.repository.KundenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class KundenService {

    @Autowired
    KundenRepository kundenRepository;

    public void saveKunde(@Valid Kunde kunde) {
        kundenRepository.saveAndFlush(kunde);
    }

    public Kunde getKunde(Long id) {
        return kundenRepository.findById(id).get();
    }

}
