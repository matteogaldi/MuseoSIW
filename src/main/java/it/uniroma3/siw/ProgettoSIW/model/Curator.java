package it.uniroma3.siw.ProgettoSIW.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
public class Curator {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String surname;

    private String placeOfBirth;

    private String dateOfBirth;

    private String badge;

    @OneToMany(mappedBy = "curator")
    private List<ArtCollection> artCollectionList;


}
