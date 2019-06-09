package ch.happy.cyclist.controller;

import ch.happy.cyclist.model.Kunde;
import ch.happy.cyclist.service.CityService;
import ch.happy.cyclist.service.KundenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@Controller
@RequestMapping("/kunde")
public class KundenController {

    @Autowired
    KundenService kundenService;

    @Autowired
    CityService cityService;

    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("kunde", new Kunde());
        return "formular";
    }

    @PostMapping("/verify")
    public String verifyCustomer(@ModelAttribute @Valid Kunde kunde, Model model) {
        model.addAttribute("kunde", kunde);
        kundenService.saveKunde(kunde);
        return "verify";
    }

    @GetMapping("/all")
    public String showAll(Model model) {
        model.addAttribute("kunden", kundenService.getAllKunden());
        return "kunden";
    }

    @GetMapping("/login")
    public String showLogin(Model model) {
        return "login";
    }

    @GetMapping("admin")
    public String admin(Model model) {
        return "admin";
    }
}
