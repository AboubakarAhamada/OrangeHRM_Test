package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

// This class contains a method to read the browser type specified in /environment/config.properties file
public class PropertyFileReader {

    // Yes, I stole this on from here https://www.tutorialspoint.com/how-to-read-the-data-from-a-properties-file-in-java
    // But not because I'm Black (Will Smith)
    public Properties readProperty(String filePath) throws IOException {
        FileInputStream fis = null;
        Properties prop = null;
        try {
            fis = new FileInputStream(filePath);
            prop = new Properties();
            prop.load(fis);
        } catch(IOException fileNotfoundException) {
            fileNotfoundException.printStackTrace();
        } finally {
            Objects.requireNonNull(fis).close();
        }

        return  prop;
    }
}
