package ch.happy.writer.controller;

import ch.happy.writer.model.Kunde;
import ch.happy.writer.service.KundenService;
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

    @GetMapping("/formular")
    public String showForm(Model model) {
        model.addAttribute("kunde", new Kunde());
        return "formular";
    }

    @PostMapping("/verify")
    public String verifyCustomer(@ModelAttribute @Valid Kunde kunde, Model model) {
        kundenService.saveKunde(kunde);
        model.addAttribute("kunde", kunde);
        return "verify";
    }
}
