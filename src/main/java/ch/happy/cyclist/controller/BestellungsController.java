package ch.happy.cyclist.controller;

import ch.happy.cyclist.model.*;
import ch.happy.cyclist.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
@RequestMapping("/shop")
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
    private Kunde kunde;
    private List<BestellPosition> bestellPositionen = new ArrayList<>();

    @GetMapping
    public String showShop(@RequestParam("id") Optional<Long> kundeId, Model model) {
        kunde = kundenService.getKunde(kundeId.get());
        artikelListe = artikelService.getAllArtikel();
        model.addAttribute("artikelListe", artikelListe);
        return "shop";
    }

    @GetMapping("/checked")
    public String selected(@RequestParam("equipment") Optional<List<Long>> equipmentId, @RequestParam("artikel") Optional<Long> artikelId, Model model) {
        artikelListe = artikelService.getAllArtikel();
        if (equipmentId.isPresent()) {
            equipmentSet = new HashSet<>();
            for (Long id : equipmentId.get()) {
                equipmentSet.add(equipmentService.getEquipmentById(id));
            }
        }
        bestellPositionen.add(new BestellPosition(equipmentSet, artikelService.getArtikel(artikelId.get())));
        model.addAttribute("bestellpositionen", bestellPositionen);
        model.addAttribute("artikelListe", artikelListe);
        bestellPositionService.saveAll(bestellPositionen);
        bestellungService.saveBestellung(new Bestellung(kunde, bestellPositionen));
        return "shop";
    }

    @GetMapping("danke")
    public String checkout(Model model) {
        System.out.println(bestellPositionen.get(0).getArtikel().getModel());
        bestellPositionService.saveAll(bestellPositionen);

        return "danke";
    }
}
