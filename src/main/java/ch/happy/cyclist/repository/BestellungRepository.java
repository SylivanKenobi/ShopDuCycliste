package ch.happy.cyclist.repository;

import ch.happy.cyclist.model.Bestellung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * interface BestellungRepository
 * @author Sylvain Gilgen
 */
public interface BestellungRepository extends JpaRepository<Bestellung, Long>, CrudRepository<Bestellung, Long> {
}
