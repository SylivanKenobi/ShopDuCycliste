package ch.happy.cyclist.repository;

import ch.happy.cyclist.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EquipmentRepository extends JpaRepository<Equipment, Long>, CrudRepository<Equipment, Long> {
}
