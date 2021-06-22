package it.uniroma3.siw.ProgettoSIW.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Collection {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;


    private String name;
    private String description;
    @ManyToOne
    private Curator curator;

    @OneToMany(mappedBy = "collection")
    private List<Artwork> artworkList;
}
