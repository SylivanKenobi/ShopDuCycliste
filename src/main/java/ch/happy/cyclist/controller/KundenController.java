package ch.happy.cyclist.controller;

import ch.happy.cyclist.model.Kunde;
import ch.happy.cyclist.service.KundenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/kunde")
public class KundenController {

    @Autowired
    KundenService kundenService;

    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("kunde", new Kunde());
        return "formular";
    }

    @PostMapping("/verify")
    public String verifyCustomer(@ModelAttribute @Valid Kunde kunde, Model model) {
        model.addAttribute("kunde", kunde);
        return "verify";
    }
/*
    @PostMapping("/danke")
    public String danke(@ModelAttribute @Valid Kunde kunde, Model model) {
        kundenService.saveKunde(kunde);
        return "danke";
    }*/

    @GetMapping("all")
    public String showAll(Model model) {
        model.addAttribute("kunden", kundenService.getAllKunden());
        return "kunden";
    }

    @GetMapping("login")
    public String showLogin(Model model) {
        return "login";
    }
}
