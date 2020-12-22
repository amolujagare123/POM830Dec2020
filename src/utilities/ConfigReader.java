package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    // a method to get the loaded properties object

    public static Properties  getPropertiesObject() throws IOException {
        // Method get the loaded properties object

        //1. Read the file using FileInputStream Object
        FileInputStream fp = new FileInputStream("Config\\config.properties");

        //2.  Create an object of properties file
        Properties prop = new Properties();

        //3. Load this object with the file object (recently read)
        prop.load(fp);

        return prop;
    }

    public static String getUrl() throws IOException {

        return  getPropertiesObject().getProperty("url");
    }

    public static String getUsername() throws IOException {

        return  getPropertiesObject().getProperty("username");
    }

    public static String getPassword() throws IOException {

        return  getPropertiesObject().getProperty("password");
    }
}
