package ca.cal.tp2.modele;

public class Dvd extends Document {
    public Dvd(int documentId, String titre, String nombreExemplaire, String director, int duree, String rating) {
        super(documentId, titre, nombreExemplaire);
        this.director = director;
        this.duree = duree;
        this.rating = rating;
    }

    private String director;
    private int duree;
    private String rating;

    public String getDirector() {
        return director;
    }

    public int getDuree() {
        return duree;
    }

    public String getRating() {
        return rating;
    }
}
