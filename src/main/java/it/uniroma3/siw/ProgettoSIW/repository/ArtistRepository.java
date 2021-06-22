package it.uniroma3.siw.ProgettoSIW.repository;

import it.uniroma3.siw.ProgettoSIW.model.Artist;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArtistRepository extends CrudRepository<Artist, Long> {
    public List<Artist> findArtistBySurname(String surname);

    public List<Artist> findArtistByNameAndSurname(String name, String surname);

    public List<Artist> findArtistByDateOfDeathIsNull();

    public List<Artist> findByDateOfDeathNotNull();
}
