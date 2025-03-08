package ca.cal.tp2.modele;


public class Livre extends Document {
    public Livre(int documentId, String titre, String nombreExemplaire,
                 String isbn, String auteur, String editeur, int nombrePages)
    {
        super(documentId, titre, nombreExemplaire);
        this.isbn = isbn;
        this.auteur = auteur;
        this.editeur = editeur;
        this.nombrePages = nombrePages;
    }

    private String isbn;
    private String auteur;
    private String editeur;
    private int nombrePages;

    public String getIsbn() {
        return isbn;
    }

    public String getAuteur() {
        return auteur;
    }

    public String getEditeur() {
        return editeur;
    }

    public int getNombrePages() {
        return nombrePages;
    }
}
