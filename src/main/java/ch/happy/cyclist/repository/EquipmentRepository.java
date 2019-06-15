package ch.happy.cyclist.repository;

import ch.happy.cyclist.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * interface EquipmentRepository
 * @author Sylvain Gilgen
 */
public interface EquipmentRepository extends JpaRepository<Equipment, Long>, CrudRepository<Equipment, Long> {
}
