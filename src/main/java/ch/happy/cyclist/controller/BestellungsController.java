package ch.happy.cyclist.controller;

import ch.happy.cyclist.model.Artikel;
import ch.happy.cyclist.model.BestellPosition;
import ch.happy.cyclist.model.Bestellung;
import ch.happy.cyclist.model.Equipment;
import ch.happy.cyclist.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.*;

/**
 * Controller zur Bestellungsverwaltung
 *
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
    private List<BestellPosition> bestellPositionen;
    private Double total;

    /**
     * Methode zum Anzeigen des Shops
     *
     * @param kundeId
     * @param model
     * @return
     */
    @GetMapping
    public String showShop(@RequestParam("id") Optional<Long> kundeId, Model model) {
        total = 0.0;
        model.addAttribute("id",kundeId.get());
        bestellPositionen = new ArrayList<>();
        artikelListe = artikelService.getAllArtikelAktiv();
        model.addAttribute("total", total);
        model.addAttribute("artikelListe", artikelListe);
        model.addAttribute("total", total);
        return "shop";
    }

    /**
     * Methode zum anzeigen der Ausgewählten Artikel+Equipment
     *
     * @param equipmentId
     * @param artikelId
     * @param model
     * @return
     */
    @PostMapping("/checked")
    public String selected(@ModelAttribute("equipment") Optional<ArrayList<Long>> equipmentId, @ModelAttribute("artikel") Optional<Long> artikelId, Model model) {
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
     *
     * @return
     */
    @GetMapping("danke")
    public String checkout(@SessionAttribute("id") Long id, SessionStatus status) {
        bestellPositionService.saveAll(bestellPositionen);
        bestellungService.saveBestellung(new Bestellung(kundenService.getKunde(id), bestellPositionService.getAll()));
        status.setComplete();
        return "danke";
    }
}
