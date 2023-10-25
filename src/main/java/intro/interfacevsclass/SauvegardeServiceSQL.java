package intro.interfacevsclass;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SauvegardeServiceSQL implements SauvegardeService {

    // définit comment l'objet doit faire le traitement.
    @Override
    public void sauvegarder(String data)  {
        String sql = "INSERT INTO DATA VALUES ('" + data + "')";
        //...

    }
}
