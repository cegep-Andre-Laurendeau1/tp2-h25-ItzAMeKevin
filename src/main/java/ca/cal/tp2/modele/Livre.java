package ca.cal.tp2.modele;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("LIVRE")
@Getter
@Setter
public class Livre extends Document {

    private String isbn;
    private String auteur;
    private String editeur;
    private int nombrePages;

    public Livre(String titre, int nbExemplaire, String isbn, String auteur, String publicateur, int nbPage) {
        super(titre, nbExemplaire);
        this.isbn = isbn;
        this.auteur = auteur;
        this.editeur = publicateur;
        this.nombrePages = nbPage;
    }

    public Livre() {}
}
