package it.uniroma3.siw.ProgettoSIW.repository;

import it.uniroma3.siw.ProgettoSIW.model.Artwork;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArtworkRepository extends CrudRepository<Artwork, Long> {

    public List<Artwork> findByTitle(String title);

    public List<Artwork> findByYear(int year);

    public List<Artwork> findByArtist_IdAndTitle(Long id, String title);

    public List<Artwork> findByCollection_Id(Long id);

    public List<Artwork> findByArtist_Id(Long id);
}
