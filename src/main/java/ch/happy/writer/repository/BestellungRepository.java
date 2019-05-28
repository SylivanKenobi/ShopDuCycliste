package ch.happy.writer.repository;

import ch.happy.writer.model.Bestellung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BestellungRepository extends JpaRepository<Bestellung, Long>, CrudRepository<Bestellung, Long> {
}
