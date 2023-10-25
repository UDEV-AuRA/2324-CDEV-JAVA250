package intro.classeattributgetter;

public class Personnage {

    private int nombrePointsVie = 100;

    public int getNombrePointsVie() {
        return nombrePointsVie;
    }

    public void setNombrePointsVie(int nombrePointsVie) {
        this.nombrePointsVie = nombrePointsVie;
    }

    public void encaisserDegat(int degat) {
        this.nombrePointsVie -= degat;
        if (this.nombrePointsVie <= 0) {
            throw new RuntimeException("Le personnage n'a plus de points de vie");
        }
    }
}
