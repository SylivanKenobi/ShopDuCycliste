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

import java.util.*;

/**
 * Controller zur Bestellungsverwaltung
 * @author Sylvain Gilgen
 */
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

    /**
     * Methode zum Anzeigen des Shops
     * @param kundeId
     * @param model
     * @return
     */
    @GetMapping
    public String showShop(@RequestParam("id") Optional<Long> kundeId, Model model) {
        total = 0.0;
        bestellPositionen = new ArrayList<>();
        this.kunde = kundeId.get();
        artikelListe = artikelService.getAllArtikelAktiv();
        model.addAttribute("total", total);
        model.addAttribute("artikelListe", artikelListe);
        model.addAttribute("total", total);
        return "shop";
    }

    /**
     * Methode zum anzeigen der Ausgewählten Artikel+Equipment
     * @param equipmentId
     * @param artikelId
     * @param model
     * @return
     */
    @GetMapping("/checked")
    public String selected(@RequestParam("equipment") Optional<List<Long>> equipmentId, @RequestParam("artikel") Optional<Long> artikelId, Model model) {
        artikelListe = artikelService.getAllArtikelAktiv();
        total = 0.0;
        if (equipmentId.isPresent()) {
            equipmentSet = new HashSet<>();
            for (Long id : equipmentId.get()) {
                equipmentSet.add(equipmentService.getEquipmentById(id));
            }
        }
        bestellPositionen.add(new BestellPosition(equipmentSet, artikelService.getArtikel(artikelId.get())));
        for (BestellPosition bestellPosition : bestellPositionen) {
            total += bestellPosition.getArtikel().getPreis();
            for (Equipment equipment : bestellPosition.getEquipmentSet()) {
                total += equipment.getPreis();
            }
        }
        model.addAttribute("total", total);
        model.addAttribute("bestellpositionen", bestellPositionen);
        model.addAttribute("artikelListe", artikelListe);
        return "shop";
    }

    /**
     * Anzeige der Dankesseite und speichern der Bestellung
     * @param model
     * @return
     */
    @GetMapping("danke")
    public String checkout(Model model) {
        bestellPositionService.saveAll(bestellPositionen);
        bestellungService.saveBestellung(new Bestellung(kundenService.getKunde(kunde), bestellPositionService.getAll()));
        return "danke";
    }
}
