package ch.happy.writer.repository;

import ch.happy.writer.model.BestellPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BestellPositionRepository extends JpaRepository<BestellPosition, Long>, CrudRepository<BestellPosition, Long> {
}
