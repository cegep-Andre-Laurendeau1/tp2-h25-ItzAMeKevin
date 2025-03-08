package ca.cal.tp2.modele;

public class Emprunteur extends Utilisateur {

    public Emprunteur(int userId, String name, String email, String phoneNumber) {
        super(userId, name, email, phoneNumber);
    }

    public void emprunte(Document document) {}

    public void retourneDocument(Document document) {}

    public void payerAmende(double amende) {}

    public void rapportHistoriqueEmprunt() {}

}
