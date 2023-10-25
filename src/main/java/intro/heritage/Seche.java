package intro.heritage;

public class Seche extends Animal {

    //private String couleurCourante = "blanc";

    //public void seCamoufler(Environnement environnement) {
    //    this.couleurCourante = environnement.getCouleur();
    //}
    // on ne peut pas utiliser l'héritage pour factoriser le concept de changement de couleur avec le caméléon.
    // =>

    private Mimetisme mimetisme = new Mimetisme();

    public void seCamoufler(Environnement environnement) {
        mimetisme.seCamoufler(environnement);
    }

}
