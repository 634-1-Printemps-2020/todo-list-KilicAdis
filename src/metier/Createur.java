package metier;

public class Createur {

    private String nom;
    private String prenom;

    public Createur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return this.nom + " " + this.prenom;
    }
}
