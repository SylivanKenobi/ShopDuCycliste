package ch.happy.cyclist.controller;

import ch.happy.cyclist.model.Artikel;
import ch.happy.cyclist.model.Equipment;
import ch.happy.cyclist.service.ArtikelService;
import ch.happy.cyclist.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Controller zur Verwaltung von artikeln und equipment
 * @author Sylvain Gilgen
 */
@Controller
@RequestMapping("/admin")
public class ArtikelController {

    @Autowired
    ArtikelService artikelService;

    @Autowired
    EquipmentService equipmentService;

    /**
     * Methode zu Darstellung der Adminseite
     * @param model
     * @return
     */
    @GetMapping
    public String admin(Model model) {
        model.addAttribute("artikelListe", artikelService.getAllArtikelAktiv());
        model.addAttribute("artikel" , new Artikel());
        model.addAttribute("equipment", new Equipment());
        model.addAttribute("equipments", equipmentService.getAllAktiv());
        return "admin";
    }

    /**
     * Methode zum Löschen eines Artikels
     * @param id
     * @param model
     * @return
     */
    @PostMapping("/delete")
    public String deleteArtikel(@RequestParam("id")Optional<List<Long>> id, Model model) {
        artikelService.deleteArtikelList(id.get());
        model.addAttribute("artikelListe", artikelService.getAllArtikelAktiv());
        model.addAttribute("artikel" , new Artikel());
        model.addAttribute("equipment", new Equipment());
        model.addAttribute("equipments", equipmentService.getAllAktiv());
        return "admin";
    }

    /**
     * Methode zum löschen von Equipment
     * @param id
     * @param model
     * @return
     */
    @PostMapping("/deleteEquipment")
    public String deleteEquipment(@RequestParam("id")Optional<List<Long>> id, Model model) {
        equipmentService.deleteEquipmentList(id.get());
        model.addAttribute("artikelListe", artikelService.getAllArtikelAktiv());
        model.addAttribute("artikel" , new Artikel());
        model.addAttribute("equipment", new Equipment());
        model.addAttribute("equipments", equipmentService.getAllAktiv());
        return "admin";
    }

    /**
     * Methode zum erstellen eines Artikels
     * @param artikel
     * @param model
     * @return
     */
    @PostMapping("/create")
    public String createArtikel(@ModelAttribute @Valid Artikel artikel, Model model) {
        artikel.setAktiv(1);
        artikelService.saveArtikel(artikel);
        model.addAttribute("artikel" , new Artikel());
        model.addAttribute("artikelListe", artikelService.getAllArtikelAktiv());
        model.addAttribute("equipment", new Equipment());
        model.addAttribute("equipments", equipmentService.getAllAktiv());
        return "admin";
    }

    /**
     * Methode zum erstellen eines Equipments
     * @param equipment
     * @param model
     * @return
     */
    @PostMapping("/equipment")
    public String createEquipment(@ModelAttribute @Valid Equipment equipment,@RequestParam("artikel")Optional<Long> artikel, Model model) {
        equipment.setArtikel(artikelService.getArtikel(artikel.get()));
        equipmentService.saveEquipment(equipment);
        model.addAttribute("artikel" , new Artikel());
        model.addAttribute("artikelListe", artikelService.getAllArtikelAktiv());
        model.addAttribute("equipment", new Equipment());
        model.addAttribute("equipments", equipmentService.getAllAktiv());
        return "admin";
    }
}
