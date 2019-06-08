package ch.happy.cyclist.repository;

import ch.happy.cyclist.model.Artikel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ArtikelRepository extends JpaRepository<Artikel, Long>, CrudRepository<Artikel, Long> {
}
