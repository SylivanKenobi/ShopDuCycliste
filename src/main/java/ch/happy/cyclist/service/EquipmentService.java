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

    public void saveEquipment(@Valid Equipment equipment) {
        equipmentRepository.saveAndFlush(equipment);
    }

    public Equipment getEquipmentById(Long id) {
        return equipmentRepository.findById(id).get();
    }

    public List<Equipment> getAll() {
        return equipmentRepository.findAll();
    }

    public List<Equipment> getAllByFk(Long Fk) {
        List<Equipment> allEquipment = equipmentRepository.findAll();
        List<Equipment> sortedEquipment = new ArrayList<>();
        for (Equipment equipment : allEquipment) {
            if (equipment.getArtikel().getId() == Fk) {
                sortedEquipment.add(equipment);
            }
        }
        return sortedEquipment;
    }

    public void deleteEquipmentList(List<Long> equipmentList) {
        for (Long id : equipmentList) {
            Equipment equipment = equipmentRepository.getOne(id);
            equipment.setAktiv(0);
            equipment.setName(equipment.getName());
            equipment.setPreis(equipment.getPreis());
            equipment.setArtikel(equipment.getArtikel());
            equipmentRepository.saveAndFlush(equipment);
        }
    }

    public List<Equipment> getAllAktiv() {
        List<Equipment> sortedArtikel = new ArrayList<>();
        List<Equipment> artikelList = equipmentRepository.findAll();
        for (Equipment equipment : artikelList) {
            if (equipment.getAktiv() == 1) {
                sortedArtikel.add(equipment);
            }
        }
        return sortedArtikel;
    }
}
