package ca.cal.tp2.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE")
@Getter
@Setter
public abstract class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String titre;
    private int nombreExemplaire;

    @OneToMany(mappedBy = "document")
    private List<EmpruntDetails> empruntDetailsList = new ArrayList<>();

    public Document(String titre, int nombreExemplaire) {
        this.titre = titre;
        this.nombreExemplaire = nombreExemplaire;
    }

    public boolean verifieDisponibilite() {
        long empruntsEnCours = empruntDetailsList.stream()
                .filter(empruntDetails -> empruntDetails.getDateRetourActuelle() == null)
                .count();
        return nombreExemplaire > empruntsEnCours;
    }

}
