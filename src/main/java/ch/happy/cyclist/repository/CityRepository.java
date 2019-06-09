package ch.happy.cyclist.repository;

import ch.happy.cyclist.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends JpaRepository<City, Long>, CrudRepository<City, Long> {

}
