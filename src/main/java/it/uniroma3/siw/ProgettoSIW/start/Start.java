package it.uniroma3.siw.ProgettoSIW.start;

import it.uniroma3.siw.ProgettoSIW.model.*;
import it.uniroma3.siw.ProgettoSIW.service.*;
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

    @Autowired
    private CuratorService curatorService;

    @Autowired
    private ArtCollectionService artCollectionService;

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

        Curator curator = new Curator();
        curator.setName("Mario");
        curator.setSurname("Rossi");
        curator.setDateOfBirth("1998-09-07");
        curator.setPlaceOfBirth("Roma");
        curator.setBadge("hdgsh");

        curatorService.add(curator);

        ArtCollection artCollection = new ArtCollection();
        artCollection.setName("Permanente");
        artCollection.setCurator(curator);
        artCollection.setDescription("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec qu");

        artCollectionService.add(artCollection);

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
        artwork.setArtCollection(artCollection);

        Artwork artwork2 = new Artwork();
        artwork2.setPhotoURL("spatialism.jpeg");
        artwork2.setArtist(artist);
        artwork2.setTitle("Tagli 2");
        artwork2.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum sit amet nulla nec");
        artwork2.setYear(1943);
        artwork2.setArtCollection(artCollection);

        artistService.add(artist);
        artworkService.add(artwork);
        artworkService.add(artwork2);


    }
}
