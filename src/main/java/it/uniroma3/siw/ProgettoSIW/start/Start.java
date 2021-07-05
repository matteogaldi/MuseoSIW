package it.uniroma3.siw.ProgettoSIW.start;

import it.uniroma3.siw.ProgettoSIW.model.Artist;
import it.uniroma3.siw.ProgettoSIW.model.Artwork;
import it.uniroma3.siw.ProgettoSIW.model.Credentials;
import it.uniroma3.siw.ProgettoSIW.model.User;
import it.uniroma3.siw.ProgettoSIW.service.ArtistService;
import it.uniroma3.siw.ProgettoSIW.service.ArtworkService;
import it.uniroma3.siw.ProgettoSIW.service.CredentialsService;
import it.uniroma3.siw.ProgettoSIW.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Start implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UserService userService;

    @Autowired
    private CredentialsService credentialsService;

    @Autowired
    private ArtistService artistService;

    @Autowired
    private ArtworkService artworkService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        User user = new User();
        user.setName("Matteo");
        user.setSurname("Galdi");
        userService.saveUser(user);

        Credentials credentials = new Credentials();
        credentials.setUsername("admin");
        credentials.setRole("ADMIN");
        credentials.setPassword("admin");
        credentials.setUser(user);
        credentialsService.saveCredentials(credentials);

        Artist artist = new Artist();
        artist.setName("Lucio");
        artist.setSurname("Fontana");
        artist.setDateOfBirth("19/8/1899");
        artist.setPlaceOfBirth("Santa Fe");
        artist.setNationality("Argentina");
        artist.setDateOfDeath("7/9/1968");
        artist.setPlaceOfDeath("Varese");
        artist.setPhotoFileName("fontana.jpeg");
        artist.setBiography("Born in Rosario, province of Santa Fe, " +
                "Argentina to Italian immigrant parents, he was the son of the sculptor Luigi Fontana ");

        Artwork artwork = new Artwork();
        artwork.setPhotoURL("tagli.jpeg");
        artwork.setArtist(artist);
        artwork.setTitle("Tagli");
        artwork.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum sit amet nulla nec");
        artwork.setYear(1943);

        Artwork artwork2 = new Artwork();
        artwork2.setPhotoURL("spatialism.jpeg");
        artwork2.setArtist(artist);
        artwork2.setTitle("Tagli 2");
        artwork2.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum sit amet nulla nec");
        artwork2.setYear(1943);

        artistService.add(artist);
        artworkService.add(artwork);
        artworkService.add(artwork2);


    }
}
