package pages.Clients;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddClient {

    @FindBy(xpath="//input[@id='client_name']")
    WebElement clientName;

    public  void setClientName(String name)
    {
       clientName.sendKeys(name);
    }

    @FindBy (xpath="//input[@id='client_surname']")
    WebElement clientSurname;

    public  void setClientSurname(String surname)
    {
        clientSurname.sendKeys(surname);
    }

    @FindBy (xpath="//input[@id='client_address_1']")
    WebElement clientAddress1;

    public  void setClientAddess1(String add1)
    {
        clientAddress1.sendKeys(add1);
    }

    @FindBy (xpath="//input[@id='client_address_2']")
    WebElement clientAddress2;

    public  void setClientAddess2(String add2)
    {
        clientAddress2.sendKeys(add2);
    }

    @FindBy (xpath="//input[@id='client_city']")
    WebElement clientCity;

    public  void setClientCity(String city)
    {
        clientCity.sendKeys(city);
    }

    @FindBy (xpath="//input[@id='client_state']")
    WebElement clientState;

    public  void setClientState(String state)
    {
        clientState.sendKeys(state);
    }

    @FindBy (xpath="//input[@id='client_zip']")
    WebElement clientZip;

    public  void setClientZip(String zip)
    {
        clientZip.sendKeys(zip);
    }

    @FindBy (xpath="//input[@id='client_phone']")
    WebElement clientPhone;

    public  void setClientPhone(String phone)
    {
        clientPhone.sendKeys(phone);
    }

    @FindBy (xpath="//input[@id='client_fax']")
    WebElement clientFax;

    void setClientFax(String fax)
    {
        clientFax.sendKeys(fax);
    }

    @FindBy (xpath="//input[@id='client_mobile']")
    WebElement clientMobile;


    void setClientMobile(String mobile)
    {
        clientMobile.sendKeys(mobile);
    }

    @FindBy (xpath="//input[@id='client_email']")
    WebElement clientEmail;


    void setClientEmail(String email)
    {
        clientEmail.sendKeys(email);
    }

    @FindBy (xpath="//input[@id='client_web']")
    WebElement clientWeb;

    void setClientWeb(String web)
    {
        clientWeb.sendKeys(web);
    }

    @FindBy (xpath="//input[@id='client_vat_id']")
    WebElement clientVatId;

    void setClientVatId(String vat)
    {
        clientVatId.sendKeys(vat);
    }

    @FindBy (xpath="//input[@id='client_tax_code']")
    WebElement clientTaxCode;

    void setClientTaxCode(String tax)
    {
        clientTaxCode.sendKeys(tax);
    }

     public AddClient(WebDriver driver)
     {
         PageFactory.initElements(driver,this);
     }

}
