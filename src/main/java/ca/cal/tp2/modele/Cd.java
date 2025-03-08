package ca.cal.tp2.modele;

public class Cd extends Document {
    public Cd(int documentId, String titre, String nombreExemplaire, String artiste, int duree, String genre) {
        super(documentId, titre, nombreExemplaire);
        this.artiste = artiste;
        this.duree = duree;
        this.genre = genre;
    }

    private String artiste;
    private int duree;
    private String genre;

    public String getArtiste() {
        return artiste;
    }

    public int getDuree() {
        return duree;
    }

    public String getGenre() {
        return genre;
    }
}
