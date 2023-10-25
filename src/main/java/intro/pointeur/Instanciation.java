package intro.pointeur;

public class Instanciation {

    public static void main(String[] args) {
        //objets

        Personnage p;
        // p.setNom("toto"); ==> Erreur

        p = new Personnage();
        Personnage p2 = p;
        // 1 seul objet mais 2 variables

        p2.setNom("toto");
        System.out.println(p.getNom());
        // si je change le nom de la variable p2, cela change aussi le nom de p car les 2
        // variables pointent sur le même objet.

        p = null;
        p2.setNom("titi");
        System.out.println(p2.getNom());
        // la variable p ne pointe plus vers le personnage, je ne peux plus y accéder à partir de P
        // Par contre p2 pointe toujours vers l'objet.

        p2 = null;
        // plus aucune variable ne pointe vers l'objet Personnage, ce dernier sera donc détruit par le garbage collector

        p2 = new Personnage();
        // je crée un nouvel objet Personnage et c'est p2 qui pointe dessus

        // type primitif en java
        int a = 10;
        int b = a;
        a = 20;
        System.out.println(b);
    }

}
