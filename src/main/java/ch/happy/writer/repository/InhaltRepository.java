package ch.happy.writer.repository;

import ch.happy.writer.model.Inhalt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface InhaltRepository extends JpaRepository<Inhalt, Long>, CrudRepository<Inhalt, Long> {
}
