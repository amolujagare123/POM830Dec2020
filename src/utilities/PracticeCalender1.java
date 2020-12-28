package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PracticeCalender1 {

    @Test
    public void calenderTest()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/datepicker/");


        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

        WebElement datePicker = driver.findElement(By.xpath("//input[@id='datepicker']"));

       // datePicker.click();

     //   datePicker.sendKeys("02/12/2020 ");


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','02/12/2020')",datePicker);


    }



}
