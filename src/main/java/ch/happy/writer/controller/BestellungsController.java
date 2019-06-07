package ch.happy.writer.controller;

import ch.happy.writer.model.Artikel;
import ch.happy.writer.model.BestellPosition;
import ch.happy.writer.model.Bestellung;
import ch.happy.writer.model.Inhalt;
import ch.happy.writer.service.ArtikelService;
import ch.happy.writer.service.BestellPositionService;
import ch.happy.writer.service.BestellungService;
import ch.happy.writer.service.InhaltService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
@RequestMapping
public class BestellungsController {

    @Autowired
    BestellungService bestellungService;

    @Autowired
    ArtikelService artikelService;

    @Autowired
    InhaltService inhaltService;

    @Autowired
    BestellPositionService bestellPositionService;

    private List<Artikel> artikelListe;
    private Set<Inhalt> inhaltSet = new HashSet<>();


    @GetMapping
    public String showShop(Model model) {
        artikelListe = artikelService.getAllArtikel();
        model.addAttribute("artikel", artikelListe);
        model.addAttribute("bestellung", new Bestellung());
        return "index";
    }

    @PostMapping("/selected")
    public String selected(@RequestParam("inhalte") Optional<List<String>> inhalteIds,@RequestParam("artikel") Optional<Long> id, Model model) {
        artikelListe = artikelService.getAllArtikel();
        if (inhalteIds.isPresent()) {
            for (String i : inhalteIds.get()) {
                inhaltSet.add(inhaltService.getInhaltById(Long.parseLong(i)));
            }
            model.addAttribute("inhalt", inhalteIds);
            model.addAttribute("artikel", artikelListe);
            model.addAttribute("bestellung", new Bestellung());
            bestellPositionService.savePos(new BestellPosition(inhaltSet, artikelService.getArtikel(id.get()),new Bestellung()));
        }
        return "index";
    }
}
