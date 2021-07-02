package it.uniroma3.siw.ProgettoSIW.controller;

import it.uniroma3.siw.ProgettoSIW.service.ArtistService;
import it.uniroma3.siw.ProgettoSIW.service.ArtworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

@Controller
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @Autowired
    private ArtworkService artworkService;

    @RequestMapping(value = "artists", method = RequestMethod.GET)
    public String getArtists(Model model) {
        model.addAttribute("artists", artistService.getAll());
        return "artist.html";
    }
}
