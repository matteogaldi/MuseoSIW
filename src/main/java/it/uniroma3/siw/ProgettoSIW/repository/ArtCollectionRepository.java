package it.uniroma3.siw.ProgettoSIW.repository;

import it.uniroma3.siw.ProgettoSIW.model.ArtCollection;
import it.uniroma3.siw.ProgettoSIW.model.Curator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArtCollectionRepository extends CrudRepository<ArtCollection, Long> {

    public List<ArtCollection> findByName(String name);

    public List<ArtCollection> findByCurator(Curator c);

    public List<ArtCollection> findByNameAndCurator(String name, Curator c);

}
