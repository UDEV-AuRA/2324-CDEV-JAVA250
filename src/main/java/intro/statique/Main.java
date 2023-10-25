package intro.statique;

public class Main {

    public static void main(String[] args) {

        Personnage p1 = new Personnage();
        p1.setNom("toto");
        p1.setNomStatic("tutu");

        Personnage p2 = new Personnage();
        p2.setNom("titi");
        p2.setNomStatic("tutu2");

        System.out.println(p1.getNom());
        System.out.println(p2.getNom());

        System.out.println(p1.getNomStatic());
        System.out.println(p2.getNomStatic());


    }

}
