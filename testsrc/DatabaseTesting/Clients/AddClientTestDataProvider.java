package DatabaseTesting.Clients;

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

public class AddClientTestDataProvider extends DoLogin {

    @Test (dataProvider = "getData")
    public void addClientTest(String clientName,String surname,String language,String add1,
                              String add2,String city,String state,String zip,String country,
                              String birthdate,String gender,String phone,String fax,
                              String mobile,String email,String web,String vat,String tax) throws IOException, ParseException, ClassNotFoundException {

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

        // 1. loading a driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2.creating a connection

        //3.creating a statement

        //4. executing a query



    }


    @DataProvider
    public Object[][] getData() throws IOException {
        FileInputStream fp = new FileInputStream("Data\\ipData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fp);
        XSSFSheet sheet = workbook.getSheet("dbTesting");
        int rowCount = sheet.getPhysicalNumberOfRows();

        Object[][] data = new Object[rowCount-1][18];

        for(int i=0;i<rowCount-1;i++)
        {
            XSSFRow row = sheet.getRow(i+1);

            for(int j=0;j<18;j++)
            {
                XSSFCell cell = row.getCell(j);
                data[i][j] = cell.toString().trim();
            }
        }

        return data;

    }

}
