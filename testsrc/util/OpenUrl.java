package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import pages.Login;

import java.io.IOException;

import static utilities.ConfigReader.*;

public class OpenUrl {

    public static  WebDriver driver;

    @BeforeClass
    public void openUrl() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(getUrl());
    }
}
