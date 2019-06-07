package ch.happy.writer.controller;

import ch.happy.writer.model.Artikel;
import ch.happy.writer.model.Inhalt;
import ch.happy.writer.service.ArtikelService;
import ch.happy.writer.service.BestellPositionService;
import ch.happy.writer.service.InhaltService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/warenkorb")
public class InhaltController {

    @Autowired
    InhaltService inhaltService;

    @Autowired
    ArtikelService artikelService;

    @Autowired
    BestellPositionService bestellPositionService;

    @GetMapping("/{id}")
    public String showShop(@PathVariable Long id, Model model) {
        List<Inhalt> inhalte = inhaltService.getAll();
        model.addAttribute("artikel", artikelService.getArtikel(id));
        model.addAttribute("inhalte", inhalte);
        return "inhalt";
    }

}
