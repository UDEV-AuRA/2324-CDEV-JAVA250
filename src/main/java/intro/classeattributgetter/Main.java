package intro.classeattributgetter;

public class Main {

    public static void main(String[] args) {
        Personnage personnage = new Personnage();

        // le personnage doit subit 10 pts de dégats.
        int nombrePointsVie = personnage.getNombrePointsVie();
        nombrePointsVie = nombrePointsVie - 10;
        personnage.setNombrePointsVie(nombrePointsVie);
        // => pas terrible car la logique est à l'exérieur

        personnage.encaisserDegat(10);
        // meilleur approche car le traitement (logique métier) est dans l'objet
    }

}
