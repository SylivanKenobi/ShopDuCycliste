package ch.happy.writer.controller;

import ch.happy.writer.model.Inhalt;
import ch.happy.writer.service.InhaltService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/warenkorb")
public class InhaltController {

    @Autowired
    InhaltService inhaltService;

    @GetMapping
    public String showShop(Model model) {
        List<Inhalt> inhalte = inhaltService.getAll();
        model.addAttribute("inhalte", inhalte);
        return "inhalt";
    }

}
