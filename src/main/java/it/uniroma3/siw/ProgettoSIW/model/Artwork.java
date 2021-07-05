package it.uniroma3.siw.ProgettoSIW.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Artwork {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private Integer year;
    private String description;
    private String photoURL;

    @ManyToOne
    private ArtCollection artCollection;

    @ManyToOne
    private Artist artist;

}
