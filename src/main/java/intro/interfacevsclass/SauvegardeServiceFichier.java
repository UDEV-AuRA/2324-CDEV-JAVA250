package intro.interfacevsclass;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SauvegardeServiceFichier implements SauvegardeService {

    // définit comment l'objet doit faire le traitement.
    @Override
    public void sauvegarder(String data)  {
        try {
            File file = new File("....");
            BufferedInputStream b = new BufferedInputStream(new FileInputStream(file));
            //...
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
