package regression;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ForgotPassword;
import pages.Login;

import java.io.IOException;

import static utilities.ConfigReader.getUrl;

public class ForgotPasswordTest {

    @Test
    public void forgotPasswordTest() throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(getUrl());

        Login login = new Login(driver);
        login.clickForgotPass();

        ForgotPassword forgotPassword = new ForgotPassword(driver);

        forgotPassword.setTxtEmail("amol@gmail.com");
        forgotPassword.clickReset();

        String expected = "Email successfully sent";

        String actual="";

        try{
            actual = driver.findElement(By.xpath("//div[contains(@class,'alert')]")).getText();
        }
        catch (Exception e)
        {

        }
        Assert.assertEquals(actual,expected,"password rest is not done properly");

    }
}
