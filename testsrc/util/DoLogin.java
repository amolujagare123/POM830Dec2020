package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;

import java.io.IOException;

import static utilities.ConfigReader.*;

public class DoLogin extends  OpenUrl{

    @BeforeClass
    public void doLogin() throws IOException {

        Login login = new Login(driver);
        login.setTxtUser(getUsername());
        login.setTxtPassword(getPassword());
        login.clickButtonLogin();
    }
}
