package ch.happy.cyclist.service;

import ch.happy.cyclist.model.City;
import ch.happy.cyclist.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Klasse zum verwalten von Citys
 */
@Service
public class CityService {

    @Autowired
    CityRepository cityRepository;

    /**
     * Methode zum abfragen von einer City
     * @param id
     * @return Liste von Citys
     */
    public City getCity(Long id) {
        return cityRepository.findById(id).get();
    }

    /**
     * Methode um alle Citys abzufragen
     * @return
     */
    public List<City> getAllCitys() {
        return cityRepository.findAll();
    }
}
