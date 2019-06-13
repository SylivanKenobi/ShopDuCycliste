package ch.happy.cyclist.controller;

import ch.happy.cyclist.model.Artikel;
import ch.happy.cyclist.model.Equipment;
import ch.happy.cyclist.service.ArtikelService;
import ch.happy.cyclist.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class ArtikelController {

    @Autowired
    ArtikelService artikelService;

    @Autowired
    EquipmentService equipmentService;

    @GetMapping
    public String admin(Model model) {
        model.addAttribute("artikelListe", artikelService.getAllArtikelAktiv());
        model.addAttribute("artikel" , new Artikel());
        model.addAttribute("equipment", new Equipment());
        return "admin";
    }

    @GetMapping("/delete")
    public String deleteArtikel(@RequestParam("id")Optional<List<Long>> id, Model model) {
        artikelService.deleteArtikelList(id.get());
        model.addAttribute("artikelListe", artikelService.getAllArtikel());
        model.addAttribute("artikel" , new Artikel());
        model.addAttribute("equipment", new Equipment());
        return "admin";
    }

    @PostMapping("/create")
    public String createArtikel(@ModelAttribute @Valid Artikel artikel,@RequestParam("aktiv")Optional<Integer> aktiv, Model model) {
        artikel.setAktiv(aktiv.get());
        artikelService.saveArtikel(artikel);
        model.addAttribute("artikel" , new Artikel());
        model.addAttribute("artikelListe", artikelService.getAllArtikel());
        model.addAttribute("equipment", new Equipment());
        return "admin";
    }

    @PostMapping("/equipment")
    public String createEquipment(@ModelAttribute @Valid Equipment equipment,@RequestParam("artikel")Optional<Long> aktiv, Model model) {
        equipment.setArtikel(artikelService.getArtikel(aktiv.get()));
        equipmentService.saveEquipment(equipment);
        model.addAttribute("artikel" , new Artikel());
        model.addAttribute("artikelListe", artikelService.getAllArtikel());
        model.addAttribute("equipment", new Equipment());
        return "admin";
    }
}
