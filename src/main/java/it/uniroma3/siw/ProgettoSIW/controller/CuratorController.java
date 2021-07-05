package it.uniroma3.siw.ProgettoSIW.controller;

import it.uniroma3.siw.ProgettoSIW.model.Curator;
import it.uniroma3.siw.ProgettoSIW.service.CuratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CuratorController {

    @Autowired
    private CuratorService service;

    @Autowired
    private CuratorValidator validator;

    @GetMapping(value = "/admin/curator")
    public String getCurator(Model model) {
        model.addAttribute("curator", new Curator());
        return "admin/curatorForm";
    }

    @PostMapping(value = "/admin/curator")
    public String addCurator(@ModelAttribute("curator") Curator curator, BindingResult result) {
        this.validator.validate(curator, result);
        if (result.hasErrors()) {
            return "/admin/curatorForm";
        }
        this.service.add(curator);
        return "/admin/home";
    }
}
