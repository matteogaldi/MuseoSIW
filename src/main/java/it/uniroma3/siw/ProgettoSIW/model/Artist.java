package it.uniroma3.siw.ProgettoSIW.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String dateOfBirth;

    @Column(nullable = false)
    private String placeOfBirth;

    private String dateOfDeath;

    private String placeOfDeath;

    private String nationality;

    private String biography;

    private String photoFileName;

    @OneToMany(mappedBy = "artist")
    private List<Artwork> artworkList;
}
