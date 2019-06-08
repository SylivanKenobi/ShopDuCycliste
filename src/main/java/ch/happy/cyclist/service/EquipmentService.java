package ch.happy.cyclist.service;

import ch.happy.cyclist.model.Equipment;
import ch.happy.cyclist.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
public class EquipmentService {

    @Autowired
    EquipmentRepository equipmentRepository;

    public void saveEquipment(@Valid Equipment equipment){
        equipmentRepository.saveAndFlush(equipment);
    }

    public Equipment getEquipmentById(Long id) {
        return equipmentRepository.findById(id).get();
    }

    public List<Equipment> getAll() {
        return equipmentRepository.findAll();
    }

    public  List<Equipment> getAllByFk(Long Fk){
        List<Equipment> allEquipment  = equipmentRepository.findAll();
        List<Equipment> sortedEquipment = new ArrayList<>();
        for(Equipment equipment : allEquipment){
            if(equipment.getArtikel().getId()==Fk){
                sortedEquipment.add(equipment);
            }
        }
        return  sortedEquipment;
    }
}
