package ch.happy.cyclist.repository;

import ch.happy.cyclist.model.BestellPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * interface BestellPositionRepository
 * @author Sylvain Gilgen
 */
public interface BestellPositionRepository extends JpaRepository<BestellPosition, Long>, CrudRepository<BestellPosition, Long> {

}
