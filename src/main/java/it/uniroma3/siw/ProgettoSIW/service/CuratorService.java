package it.uniroma3.siw.ProgettoSIW.service;

import it.uniroma3.siw.ProgettoSIW.model.Curator;
import it.uniroma3.siw.ProgettoSIW.repository.CuratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuratorService {

    @Autowired
    private CuratorRepository repository;

    public List<Curator> findAll() {
        return (List<Curator>) this.repository.findAll();
    }

    public Curator add(Curator curator) {
        return this.repository.save(curator);
    }
}
