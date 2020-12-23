package regression.Clients;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.Login;
import pages.Menu;

import java.io.IOException;

import static utilities.ConfigReader.*;

public class AddClientTest {

    @Test
    public void addClientTest() throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(getUrl());

        Login login = new Login(driver);

        login.setTxtUser(getUsername());
        login.setTxtPassword(getPassword());
        login.clickButtonLogin();


        Menu menu = new Menu(driver);

        menu.clickAddClient();
    }

}
