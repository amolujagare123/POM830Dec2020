package regression.Clients;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
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
    }

}
