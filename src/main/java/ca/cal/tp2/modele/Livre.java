package ca.cal.tp2.modele;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("LIVRE")
public class Livre extends Document {
    public Livre(String titre, String nombreExemplaire,
                 String isbn, String auteur, String editeur, int nombrePages)
    {
        super(titre, nombreExemplaire);
        this.isbn = isbn;
        this.auteur = auteur;
        this.editeur = editeur;
        this.nombrePages = nombrePages;
    }

    private String isbn;
    private String auteur;
    private String editeur;
    private int nombrePages;

    public Livre() {

    }
}
