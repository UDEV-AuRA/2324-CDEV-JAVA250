package docmosis;

import java.io.File;

import com.docmosis.SystemManager;
import com.docmosis.document.DocumentProcessor;
import com.docmosis.template.population.DataProviderBuilder;
import com.docmosis.util.Configuration;

/**
 * A simple example showing Docmosis creating a PDF with dynamic data from a
 * DOC template. 
 */
public class SimpleRender
{
    public static void main(String[] args)
    {
        String key = new String("...");
        String site = new String("Free Trial Java");
        String officePath = new String("C:\\Program Files\\LibreOffice");

        if (!new File(officePath).isDirectory() || !new File(officePath).canRead()) {
            System.err.println("\nPlease check \"officePath\" is set to the " +
                               "install dir for OpenOffice or LibreOffice"); 
            System.exit(1);
        }
        // Create the initialisation configuration
        Configuration config = new Configuration(key, site, officePath);

        // Tell Docmosis to use one embedded converter
        config.setConverterPoolConfiguration("1");
        
        // Use the DataProviderBuilder to build the data provider from a String array.
        DataProviderBuilder dpb = new DataProviderBuilder();

        dpb.add("date", "12 Nov 2015");
        dpb.add("message", "This Docmosis document engine is working!");

        try {

            // Initialise the system based on configuration
            SystemManager.initialise(config);

            File templateFile = new File("WelcomeTemplate.doc");
            File outputFile = new File("newDocument.pdf");

            if (!templateFile.canRead()) {
                System.err.println("\nCannot find '" + templateFile + "' in: " + new File("").getCanonicalPath());
            } else {

                // Create the document
                DocumentProcessor.renderDoc(templateFile, outputFile, dpb.getDataProvider());

                System.out.println("\nCreated: " + outputFile.getCanonicalPath());
            }
        } catch (Exception e){
            System.err.println("\nPlease check the following: " + e.getMessage());
        } finally {
            // shutdown the system
            SystemManager.release();
        }
    }
}