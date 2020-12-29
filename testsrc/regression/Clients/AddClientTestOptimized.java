package regression.Clients;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.Clients.AddClient;
import pages.Login;
import pages.Menu;
import util.DoLogin;

import java.io.IOException;
import java.text.ParseException;

import static utilities.ConfigReader.*;

public class AddClientTestOptimized extends DoLogin {

    @Test
    public void addClientTest() throws IOException, ParseException {

        Menu menu = new Menu(driver);
        menu.clickAddClient();

        AddClient addClient = new AddClient(driver);

        addClient.setClientName("Komal");
        addClient.setClientSurname("xyz");
        addClient.setLanguage("Thai");
        addClient.setClientAddess1("abcd");
        addClient.setClientAddess2("my address");
        addClient.setClientCity("pune");
        addClient.setClientState("maharashtra");
        addClient.setClientZip("898989");
        addClient.setCountry("Malaysia");
        addClient.setDate("1/03/2020");
        addClient.setGender("Other");
        addClient.setClientPhone("898989");
        addClient.setClientFax("89898");
        addClient.setClientMobile("8989889");
        addClient.setClientEmail("amol@gmail.com");
        addClient.setClientWeb("www.xyz.com");
        addClient.setClientVatId("21212");
        addClient.setClientTaxCode("34343");
        addClient.clickSave();



    }

}
