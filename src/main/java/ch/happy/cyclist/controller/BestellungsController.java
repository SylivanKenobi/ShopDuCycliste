package ch.happy.cyclist.controller;

import ch.happy.cyclist.model.Artikel;
import ch.happy.cyclist.model.BestellPosition;
import ch.happy.cyclist.model.Bestellung;
import ch.happy.cyclist.model.Equipment;
import ch.happy.cyclist.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.math.BigDecimal;
import java.util.*;

@Controller
@RequestMapping("/shop")
@SessionAttributes("id")
public class BestellungsController {

    @Autowired
    ArtikelService artikelService;

    @Autowired
    EquipmentService equipmentService;

    @Autowired
    BestellPositionService bestellPositionService;

    @Autowired
    BestellungService bestellungService;

    @Autowired
    KundenService kundenService;

    private List<Artikel> artikelListe;
    private Set<Equipment> equipmentSet;
    private Long kunde;
    private List<BestellPosition> bestellPositionen;
    private Double total = 0.0;

    @GetMapping
    public String showShop(@RequestParam("id") Optional<Long> kundeId, Model model) {
        bestellPositionen = new ArrayList<>();
        kundenService.flushKunde();
        this.kunde = kundeId.get();
        artikelListe = artikelService.getAllArtikel();
        model.addAttribute("total", total);
        model.addAttribute("artikelListe", artikelListe);
        return "shop";
    }

    @GetMapping("/checked")
    public String selected(@RequestParam("equipment") Optional<List<Long>> equipmentId, @RequestParam("artikel") Optional<Long> artikelId, Model model) {
        artikelListe = artikelService.getAllArtikel();
        total = 0.0;
        if (equipmentId.isPresent()) {
            equipmentSet = new HashSet<>();
            for (Long id : equipmentId.get()) {
                equipmentSet.add(equipmentService.getEquipmentById(id));
            }
        }
        bestellPositionen.add(new BestellPosition(equipmentSet, artikelService.getArtikel(artikelId.get())));
        for (BestellPosition bestellPosition : bestellPositionen) {
            total+=bestellPosition.getArtikel().getPreis();
            for (Equipment equipment : bestellPosition.getEquipmentSet()) {
                total+=equipment.getPreis();
            }
        }
        model.addAttribute("total", total);
        model.addAttribute("bestellpositionen", bestellPositionen);
        model.addAttribute("artikelListe", artikelListe);
        return "shop";
    }

    @GetMapping("danke")
    public String checkout(Model model) {
        bestellPositionService.saveAll(bestellPositionen);
        bestellungService.saveBestellung(new Bestellung(kundenService.getKunde(kunde), bestellPositionService.getAll()));

        return "danke";
    }
}
