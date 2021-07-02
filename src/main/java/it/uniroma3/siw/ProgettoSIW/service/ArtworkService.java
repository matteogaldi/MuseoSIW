package it.uniroma3.siw.ProgettoSIW.service;

import it.uniroma3.siw.ProgettoSIW.model.Artwork;
import it.uniroma3.siw.ProgettoSIW.repository.ArtworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ArtworkService {

    @Autowired
    private ArtworkRepository artworkRepository;

    @Transactional
    public Artwork add(Artwork artwork) {
        return artworkRepository.save(artwork);
    }

    public List<Artwork> findByTitle(String title) {
        return artworkRepository.findByTitle(title);
    }

    public List<Artwork> findByArtistId(Long id) {
        return artworkRepository.findByArtist_Id(id);
    }

    @Transactional
    public Artwork findById(Long id) {
        Optional<Artwork> artwork = artworkRepository.findById(id);
        return artwork.orElse(null);
    }

    public List<Artwork> getAll() {
        return (List<Artwork>) artworkRepository.findAll();
    }

    @Transactional
    public boolean alreadyExists(Artwork artwork) {
        List<Artwork> artworks = artworkRepository.findByTitle(artwork.getTitle());
        return artworks.size() > 0;
    }
}
