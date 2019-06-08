package ch.happy.cyclist.service;

import ch.happy.cyclist.model.Kunde;
import ch.happy.cyclist.repository.KundenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

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

    public List<Kunde> getAllKunden() {
        return kundenRepository.findAll();
    }

}
