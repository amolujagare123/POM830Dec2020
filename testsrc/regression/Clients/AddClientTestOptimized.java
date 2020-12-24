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

import static utilities.ConfigReader.*;

public class AddClientTestOptimized extends DoLogin {

    @Test
    public void addClientTest() throws IOException {

        Menu menu = new Menu(driver);

        menu.clickAddClient();

        AddClient addClient = new AddClient(driver);
        addClient.setClientName("Komal");
        addClient.setClientSurname("xyz");
        addClient.setClientAddess1("abcd");
        addClient.setClientAddess2("my address");
        addClient.setClientCity("pune");
        addClient.setClientState("maharashtra");
        addClient.setClientZip("898989");
        addClient.setClientPhone("898989");

    }

}
