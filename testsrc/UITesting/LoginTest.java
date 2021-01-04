package UITesting;

import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import util.OpenUrl;

public class LoginTest extends OpenUrl {

    Login login;

    @BeforeClass
    public void initObject()
    {
        login = new Login(driver);
    }


    @Test
    public void txtUsernameVisibilityCheck()
    {
        boolean expected = true;

        boolean actual;
        try {
            actual = login.txtUser.isDisplayed();
        }
        catch (Exception e )
        {
            actual = false;
        }
        Assert.assertEquals(actual,expected,"user name text box is not present");
    }


    @Test
    public void txtUserEnabilityCheck()
    {
        boolean expected =true;
        boolean actual;
        try {
            actual = login.txtUser.isEnabled();
        }
        catch (Exception e)
        {
            actual =false;
        }
        Assert.assertEquals(actual,expected,"user name text box is not enabled");

        }


    @Test
    public void txtUserWatrmarkCheck()
    {
       String expected = "Email";
        String actual;
       try {
           actual = login.txtUser.getAttribute("placeholder");
       }
       catch (Exception e)
       {
           actual="";
       }

        Assert.assertEquals(actual,expected,"wrong watermark");
    }

    @Test
    public void lblLoginTextVerify()
    {
        String expected = "Login";

        String actual;

        try
        {
            actual = login.lblLogin.getText();
        }
        catch (Exception e)
        {
            actual="";
        }
        Assert.assertEquals(actual,expected,"wrong Text spelling");

    }

    @Test
    public void lblLoginFontSizeCheck()
    {
        String expected = "36px";

        String actual ;
        try
        {
            actual = login.lblLogin.getCssValue("font-size");
            System.out.println("actual="+actual);
        }
        catch (Exception e)
        {
            actual = "";
        }

        Assert.assertEquals(actual,expected,"wrong font size");
    }

    @Test
    public void lblEmailFontFamilyCheck()
    {
        String expected = "-apple-system, system-ui, BlinkMacSystemFont, \"Segoe UI\", Roboto, \"Helvetica Neue\", Arial, sans-serif";

        String actual ;
        try
        {
            actual = login.lblLogin.getCssValue("font-family");
            System.out.println("actual="+actual);
        }
        catch (Exception e)
        {
            actual = "";
        }

        Assert.assertEquals(actual,expected,"wrong font family");
    }


    @Test
    public void lblEmailFontAvailablilityCheck()
    {
        // check /verify whether the font'san-sarif' is present in the fomt familiy or not

        String expected = "sans-serif";
       // String expected = "Times New Roman";

        String fontFamily ;
        try
        {
            fontFamily = login.lblLogin.getCssValue("font-family");
            System.out.println("actual="+fontFamily);
        }
        catch (Exception e)
        {
            fontFamily = "";
        }


        boolean result = fontFamily.contains(expected);

        Assert.assertTrue(result,"given font is not present in the font family");

    }

    @Test
    public void btnLoginVerifyColor()
    {
        String expected = "#2C8EDD";
        String btnColorRgb ; // rgb format
        String actual = "";
        try
        {
            btnColorRgb = login.btnLogin.getCssValue("background-color");

            actual = Color.fromString(btnColorRgb).asHex().toUpperCase();
            System.out.println("actual="+actual);

        }
        catch (Exception e)
        {
            btnColorRgb = "";
        }

        Assert.assertEquals(actual,expected,"incorrect color");
    }


}
