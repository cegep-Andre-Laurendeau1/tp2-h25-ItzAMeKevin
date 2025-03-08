package ca.cal.tp2.modele;

import lombok.Data;

@Data
public abstract class Utilisateur {
    private final int id;
    private final String name;
    private final String email;
    private final String phoneNumber;

    protected Utilisateur(int userId, String name, String email, String phoneNumber) {
        this.id = userId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // A mettre dans le service
    public void login() {}
}
