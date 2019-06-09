package ch.happy.cyclist.service;

import ch.happy.cyclist.model.City;
import ch.happy.cyclist.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    @Autowired
    CityRepository cityRepository;

    public Optional<City> getCity(Long id) {
        return cityRepository.findById(id);
    }

    public List<City> getAllCitys() {
        return cityRepository.findAll();
    }
}
