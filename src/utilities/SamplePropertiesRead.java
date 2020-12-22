package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class SamplePropertiesRead {

    public static void main(String[] args) throws IOException {

       //1. Read the file using FileInputStream Object
        FileInputStream fp = new FileInputStream("Config\\config.properties");

       //2.  Create an object of properties file
        Properties prop =  new Properties();

       //3. Load this object with the file object (recently read)
        prop.load(fp);

       //4.  Using getProperty method get the value of the key
        String myUrl = prop.getProperty("url");

        System.out.println(myUrl);

        System.out.println(prop.getProperty("username"));
        System.out.println(prop.getProperty("password"));
    }

}
