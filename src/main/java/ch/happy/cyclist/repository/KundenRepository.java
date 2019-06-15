package ch.happy.cyclist.repository;

import ch.happy.cyclist.model.Kunde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * interface KundenRepository
 * @author Sylvain Gilgen
 */
public interface KundenRepository extends JpaRepository<Kunde, Long>, CrudRepository<Kunde, Long> {
    @Override
    Optional<Kunde> findById(Long aLong);
}
