package it.uniroma3.siw.ProgettoSIW.controller;

import it.uniroma3.siw.ProgettoSIW.model.Artist;
import it.uniroma3.siw.ProgettoSIW.service.ArtistService;
import it.uniroma3.siw.ProgettoSIW.service.ArtworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

@Controller
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @Autowired
    private ArtistValidator artistValidator;

    @Autowired
    private ArtworkService artworkService;

    @RequestMapping(value = "/artists", method = RequestMethod.GET)
    public String getArtists(Model model) {
        model.addAttribute("artists", artistService.findAll());
        return "artists";
    }

    @RequestMapping(value = "/artist/{id}", method = RequestMethod.GET)
    public String getArtist(@PathVariable("id") Long id, Model model) {
        Artist artist = artistService.getById(id);
        model.addAttribute("artist", artist);
        model.addAttribute("artworks", artworkService.findByArtistId(artist.getId()));
        return "artist";
    }

    @RequestMapping(value = "/admin/artist", method = RequestMethod.POST)
    public String addArtist(@ModelAttribute("artist") Artist artist, Model model, BindingResult bindingResult) {
        this.artistValidator.validate(artist, bindingResult);
        if (!bindingResult.hasErrors()) {
            Artist a = this.artistService.add(artist);
            model.addAttribute("artist", a);
            return "admin/home";
        }
        return "admin/artworkForm";
    }

    @RequestMapping(value = "/admin/artist", method = RequestMethod.GET)
    public String showArtistForm(Model model) {
        model.addAttribute("artist", new Artist());
        return "admin/artistForm";
    }

}
