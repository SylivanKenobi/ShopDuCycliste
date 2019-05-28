package ch.happy.writer.service;

import ch.happy.writer.model.Inhalt;
import ch.happy.writer.repository.InhaltRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class InhaltService {

    @Autowired
    InhaltRepository inhaltRepository;

    public void saveItem(@Valid Inhalt inhalt){
        inhaltRepository.saveAndFlush(inhalt);
    }

    public  Inhalt getInhaltById(Long id) {
        return inhaltRepository.findById(id).get();
    }
}
