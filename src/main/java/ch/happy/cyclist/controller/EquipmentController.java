package ch.happy.cyclist.controller;

import ch.happy.cyclist.model.Equipment;
import ch.happy.cyclist.service.ArtikelService;
import ch.happy.cyclist.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

/**
 * Klasse zur Auswahl von Equipment
 * @author Sylvain Gilgen
 */
@Controller
@RequestMapping("/warenkorb")
public class EquipmentController {

    @Autowired
    EquipmentService equipmentService;

    @Autowired
    ArtikelService artikelService;

    /**
     * Methode zum Auswählen von Equipment
     * @param id
     * @param model
     * @return
     */
    @GetMapping(params = "id")
    public String selectInhalt(@RequestParam("id") Optional<Long> id, Model model){
        List<Equipment> equipmentList = equipmentService.getAllByFk(id.get());
        model.addAttribute("equipmentList", equipmentList);
        model.addAttribute("artikel", artikelService.getArtikel(id.get()));
        return "equipment";
    }

}
