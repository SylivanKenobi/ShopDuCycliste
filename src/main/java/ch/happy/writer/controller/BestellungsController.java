package ch.happy.writer.controller;

import ch.happy.writer.model.Bestellung;
import ch.happy.writer.service.BestellungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class BestellungsController {

    @Autowired
    BestellungService bestellungService;

    @GetMapping
    public String showShop(Model model) {
        model.addAttribute("bestellung", new Bestellung());
        return "index";
    }


}
