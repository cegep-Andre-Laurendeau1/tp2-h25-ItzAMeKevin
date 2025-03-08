package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE")
@Getter
public abstract class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String titre;
    private String nombreExemplaire;

    @OneToMany(mappedBy = "document")
    private List<EmpruntDetails> empruntDetailsList = new ArrayList<>();

    public Document(String titre, String nombreExemplaire) {
        this.titre = titre;
        this.nombreExemplaire = nombreExemplaire;
    }
}
