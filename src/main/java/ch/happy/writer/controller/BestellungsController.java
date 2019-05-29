package ch.happy.writer.controller;

import ch.happy.writer.model.Artikel;
import ch.happy.writer.model.Bestellung;
import ch.happy.writer.model.Inhalt;
import ch.happy.writer.service.ArtikelService;
import ch.happy.writer.service.BestellungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping
public class BestellungsController {

    @Autowired
    BestellungService bestellungService;

    @Autowired
    ArtikelService artikelService;

    @GetMapping
    public String showShop(Model model) {
        List<Artikel> artikelListe = artikelService.getAllArtikel();
        model.addAttribute("artikel", artikelListe);
        model.addAttribute("bestellung", new Bestellung());
        return "index";
    }

    @PostMapping("/selected")
    public String selected(Model model){
        return "index";
    }
}
