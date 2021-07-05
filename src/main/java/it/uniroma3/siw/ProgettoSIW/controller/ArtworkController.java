package it.uniroma3.siw.ProgettoSIW.controller;

import it.uniroma3.siw.ProgettoSIW.model.Artwork;
import it.uniroma3.siw.ProgettoSIW.service.ArtCollectionService;
import it.uniroma3.siw.ProgettoSIW.service.ArtistService;
import it.uniroma3.siw.ProgettoSIW.service.ArtworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class ArtworkController {

    @Autowired
    private ArtworkService service;

    @Autowired
    private ArtworkValidator validator;

    @Autowired
    private ArtistService artistService;

    @Autowired
    private ArtCollectionService collectionService;

    @GetMapping(value = "/artworks")
    public String getArtworks(Model model) {
        model.addAttribute("artworks", this.service.getAll());
        return "artworks";
    }

    @GetMapping(value = "/artwork/{id}")
    public String getArtwork(@PathVariable("id") Long id, Model model) {
        Artwork artwork = this.service.findById(id);
        model.addAttribute("artwork", artwork);
        return "artwork";
    }

    @PostMapping(value = "/admin/artwork")
    public String addNewArtwork(@ModelAttribute("artwork") Artwork artwork, Model model, BindingResult result) {
        this.validator.validate(artwork, result);
        if (!result.hasErrors()) {
            this.service.add(artwork);
            return "admin/home";
        }
        return "admin/artworkForm";
    }

    @GetMapping(value = "/admin/artwork")
    public String showArtworkForm(Model model) {
        model.addAttribute("artwork", new Artwork());
        model.addAttribute("artists", this.artistService.findAll());
        model.addAttribute("artCollections", this.collectionService.findAll());
        return "admin/artworkForm";
    }
}
