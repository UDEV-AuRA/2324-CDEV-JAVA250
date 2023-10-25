package intro.statique;

public class Personnage {

    private String nom;

    private static String nomStatic;


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public static String getNomStatic() {
        return nomStatic;
    }

    public static void setNomStatic(String nomStatic) {
        Personnage.nomStatic = nomStatic;
    }
}
