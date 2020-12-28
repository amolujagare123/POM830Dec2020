package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PracticeCalender2 {

    @Test
    public void calenderTest()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.yatra.com/domestic-airlines/jet-airways.html");


        WebElement datePicker = driver.findElement(By.name("flight_depart_date"));

       // datePicker.click();

     //   datePicker.sendKeys("02/12/2020 ");


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','7 Jan')",datePicker);


    }



}
