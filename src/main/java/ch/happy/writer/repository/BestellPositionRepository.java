package ch.happy.writer.repository;

import ch.happy.writer.model.BestellPosition;
import ch.happy.writer.model.Inhalt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;


public interface BestellPositionRepository extends JpaRepository<BestellPosition, Long>, CrudRepository<BestellPosition, Long> {

}
