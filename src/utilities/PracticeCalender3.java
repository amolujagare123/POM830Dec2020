package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.joda.time.DateTime;
import org.joda.time.Months;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PracticeCalender3 {

    @Test
    public void calenderTest() throws ParseException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/datepicker/");


        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

        WebElement datePicker = driver.findElement(By.xpath("//input[@id='datepicker']"));

        datePicker.click();

         String setDateStr = "23/03/2020"; // dd/MM/yyyy
         Date setDate = new SimpleDateFormat("dd/MM/yyyy").parse(setDateStr);


         String currDateStr = driver.findElement(By.className("ui-datepicker-title")).getText();
         // MMMM yyyy - Dec 2020
         Date currDate = new SimpleDateFormat("MMMM yyyy").parse(currDateStr);


         int monthDiff = Months.monthsBetween(new DateTime(currDate).withDayOfMonth(1),

                        new DateTime(setDate).withDayOfMonth(1)).getMonths();

        System.out.println(monthDiff); // -9

        boolean isFuture = true;

           if(monthDiff<0) {
               isFuture = false;
               monthDiff = monthDiff * (-1);
           }

           for (int i = 0 ; i<monthDiff ;i++)
           {
               if (isFuture)
                   driver.findElement(By.xpath("//span[normalize-space()='Next']")).click(); // next webelement
               else
                   driver.findElement(By.xpath("//span[normalize-space()='Prev']")).click(); // previous web element

           }

    }



}
