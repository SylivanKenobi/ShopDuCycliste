package ch.happy.cyclist.controller;

import ch.happy.cyclist.model.Kunde;
import ch.happy.cyclist.service.CityService;
import ch.happy.cyclist.service.KundenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Klasse zur Verwaltung von Kunden
 * @author Sylvain Gilgen
 */
@Controller
@RequestMapping("/kunde")
@SessionAttributes("id")
public class KundenController {

    @Autowired
    HttpSession session;

    @Autowired
    KundenService kundenService;

    @Autowired
    CityService cityService;

    /**
     * Methode zur Darstellung vom Formular
     * @param model
     * @return
     */
    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("kunde", new Kunde());
        return "formular";
    }

    /**
     * Methode zur Darstellung der Kundenbestätigungsseite
     * @param kunde
     * @param model
     * @return
     */
    @PostMapping("/verify")
    public String verifyCustomer(@ModelAttribute @Valid Kunde kunde, Model model) {
        model.addAttribute("kunde", kunde);
        kundenService.saveKunde(kunde);
        return "verify";
    }

    /**
     * Methode zum anzeigen aller Kunden
     * @param model
     * @return
     */
    @GetMapping("/all")
    public String showAll(Model model) {
        model.addAttribute("kunden", kundenService.getAllKunden());
        model.addAttribute("customerId");
        return "kunden";
    }
}
