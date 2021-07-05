package it.uniroma3.siw.ProgettoSIW.service;

import it.uniroma3.siw.ProgettoSIW.model.ArtCollection;
import it.uniroma3.siw.ProgettoSIW.repository.ArtCollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ArtCollectionService {

    @Autowired
    ArtCollectionRepository artCollectionRepository;

    @Transactional
    public ArtCollection add(ArtCollection ac) {
        return artCollectionRepository.save(ac);
    }

    public List<ArtCollection> findAll() {
        return (List<ArtCollection>) artCollectionRepository.findAll();
    }

    public ArtCollection findById(Long id) {
        Optional<ArtCollection> artCollection = artCollectionRepository.findById(id);
        return artCollection.orElse(null);
    }
}
