package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

    //  WebDriver driver;

    //  WebElement txtEmail = driver.findElement(By.xpath(""));

    // page factory

    @FindBy(xpath = "//input[@id='email']")
    WebElement txtUser;

    @FindBy(xpath = "//input[@id='password']")
    WebElement txtPassword;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement btnLogin;

    @FindBy (xpath = "//a[normalize-space()='I forgot my password']")
    WebElement lnkForgotPass;

    public void clickForgotPass()
    {
        lnkForgotPass.click();
    }

    public Login(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }


    public void setTxtUser(String user)
    {
        txtUser.sendKeys(user);
    }

    public void setTxtPassword(String pass)
    {
        txtPassword.sendKeys(pass);
    }

    public void clickButtonLogin()
    {
        btnLogin.click();
    }
}
