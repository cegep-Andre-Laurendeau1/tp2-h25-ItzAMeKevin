package ca.cal.tp2.modele;

public class Prepose extends Utilisateur{
    public Prepose(int userId, String name, String email, String phoneNumber) {
        super(userId, name, email, phoneNumber);
    }

    // A mettre dans le service
    public void entreNouveauDocument(Document doc) {}

    // A mettre dans le service
    public void collecteAmende(Emprunteur emprunteur, double amende) {}

    // A mettre dans le service
    public String rapportAmendes() {
        return "";
    }

    // A mettre dans le service
    public String rapportEmprunts() {
        return "";
    }
}
