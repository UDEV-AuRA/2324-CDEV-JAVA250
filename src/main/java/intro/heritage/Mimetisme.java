package intro.heritage;

public class Mimetisme {
    private String couleurCourante = "blanc";

    public void seCamoufler(Environnement environnement) {
        this.couleurCourante = environnement.getCouleur();
    }

    public String getCouleurCourante() {
        return couleurCourante;
    }
}
