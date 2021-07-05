package it.uniroma3.siw.ProgettoSIW.controller;

import it.uniroma3.siw.ProgettoSIW.model.ArtCollection;
import it.uniroma3.siw.ProgettoSIW.service.ArtCollectionService;
import it.uniroma3.siw.ProgettoSIW.service.CuratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArtCollectionController {

    @Autowired
    private ArtCollectionService service;

    @Autowired
    private ArtCollectionValidator validator;

    @Autowired
    private CuratorService curatorService;

    @GetMapping(value = "/collections")
    public String getAllCollections(Model model) {
        model.addAttribute("artCollections", this.service.findAll());
        return "artCollections";
    }

    @GetMapping(value = "/collection/{id}")
    public String getCollection(@PathVariable("id") Long id, Model model) {
        model.addAttribute("artCollection", this.service.findById(id));
        return "artCollection";
    }

    @GetMapping(value = "/admin/collection")
    public String getCollectionForm(Model model) {
        model.addAttribute("artCollection", new ArtCollection());
        model.addAttribute("curators", this.curatorService.findAll());
        return "/admin/artCollectionForm";
    }

    @PostMapping(value = "/admin/collection")
    public String createCollection(@ModelAttribute("artCollection") ArtCollection artCollection, Model model, BindingResult result) {
        this.validator.validate(artCollection, result);
        if (result.hasErrors()) {
            return "/admin/artCollectionForm";
        }
        this.service.add(artCollection);
        return "/admin/home";
    }
}
