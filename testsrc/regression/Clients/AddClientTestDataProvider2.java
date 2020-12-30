package regression.Clients;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Clients.AddClient;
import pages.Menu;
import util.DoLogin;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;

public class AddClientTestDataProvider2 extends DoLogin {

    @Test (dataProvider = "getData")
    public void addClientTest(String clientName,String surname,String language,String add1,
                              String add2,String city,String state,String zip,String country,
                              String birthdate,String gender,String phone,String fax,
                              String mobile,String email,String web,String vat,String tax
                                , String expected) throws IOException, ParseException {

        Menu menu = new Menu(driver);
        menu.clickAddClient();

        AddClient addClient = new AddClient(driver);

        addClient.setClientName(clientName);
        addClient.setClientSurname(surname);
        addClient.setLanguage(language);
        addClient.setClientAddess1(add1);
        addClient.setClientAddess2(add2);
        addClient.setClientCity(city);
        addClient.setClientState(state);
        addClient.setClientZip(zip);
        addClient.setCountry(country);
        addClient.setDate(birthdate);
        addClient.setGender(gender);
        addClient.setClientPhone(phone);
        addClient.setClientFax(fax);
        addClient.setClientMobile(mobile);
        addClient.setClientEmail(email);
        addClient.setClientWeb(web);
        addClient.setClientVatId(vat);
        addClient.setClientTaxCode(tax);
        addClient.clickSave();


        boolean result = driver.getPageSource().contains(expected);

        Assert.assertTrue(result,"Given text is not present on the page");



    }


    @DataProvider
    public Object[][] getData() throws IOException {
        FileInputStream fp = new FileInputStream("Data\\ipData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fp);
        XSSFSheet sheet = workbook.getSheet("Sheet3");
        int rowCount = sheet.getPhysicalNumberOfRows();

        Object[][] data = new Object[rowCount-1][19];

        for(int i=0;i<rowCount-1;i++)
        {
            XSSFRow row = sheet.getRow(i+1);

            for(int j=0;j<19;j++)
            {
                XSSFCell cell = row.getCell(j);
                data[i][j] = cell.toString().trim();
            }
        }

        return data;

    }

}
