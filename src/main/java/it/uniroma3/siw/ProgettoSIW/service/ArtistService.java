package it.uniroma3.siw.ProgettoSIW.service;

import it.uniroma3.siw.ProgettoSIW.model.Artist;
import it.uniroma3.siw.ProgettoSIW.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    @Transactional
    public Artist add(Artist artist) {
        return artistRepository.save(artist);
    }

    public List<Artist> findAll() {
        return (List<Artist>) artistRepository.findAll();
    }

    @Transactional
    public Artist getById(Long id) {
        Optional<Artist> artist = artistRepository.findById(id);
        return artist.orElse(null);
    }

    public boolean alreadyExists(Artist artist) {
        List<Artist> artists = artistRepository.findArtistByNameAndSurname(artist.getName(), artist.getSurname());
        return artists.size() > 0;
    }
}
