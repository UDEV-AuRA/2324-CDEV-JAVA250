package intro.heritage;

public class Cameleon extends Animal {

    private String couleurCourante = "vert";

    public void seCamoufler(Environnement environnement) {
        this.couleurCourante = environnement.getCouleur();
    }

}
