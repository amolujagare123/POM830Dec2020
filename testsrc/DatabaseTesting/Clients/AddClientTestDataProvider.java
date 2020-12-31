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
import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;

import static utilities.Conversion.*;

public class AddClientTestDataProvider extends DoLogin {

    @Test (dataProvider = "getData")
    public void addClientTest(String clientName,String surname,String language,String add1,
                              String add2,String city,String state,String zip,String country,
                              String birthdate,String gender,String phone,String fax,
                              String mobile,String email,String web,String vat,String tax) throws IOException, ParseException, ClassNotFoundException, SQLException {

       ArrayList<String> expected = new ArrayList<>();

        expected.add(clientName);
        expected.add(surname);
        expected.add(language.toLowerCase());
        expected.add(add1);
        expected.add(add2);
        expected.add(city);
        expected.add(state);
        expected.add(zip);
        expected.add(country);
        expected.add(birthdate);
        expected.add(gender);
        expected.add(phone);
        expected.add(fax);
        expected.add(mobile);
        expected.add(email);
        expected.add(web);
        expected.add(vat);
        expected.add(tax);


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

        String url ="jdbc:mysql://localhost:3306/ip830";
        String user = "root";
        String pass = "root";
        Connection con = DriverManager.getConnection(url,user,pass);

        //3.creating a statement
        Statement st = con.createStatement();

        //4. executing a query

        String sql ="SELECT * FROM ip_clients where client_name='"+clientName+"'";

        ResultSet rs = st.executeQuery(sql);


        ArrayList<String> actual = new ArrayList<>();

        while(rs.next())
        {
            actual.add(rs.getString("client_name"));
            actual.add(rs.getString("client_surname"));
            actual.add(rs.getString("client_language"));
            actual.add(rs.getString("client_address_1"));
            actual.add(rs.getString("client_address_2"));
            actual.add(rs.getString("client_city"));
            actual.add(rs.getString("client_state"));
            actual.add(rs.getString("client_zip"));

            String shortCountry = rs.getString("client_country");
            String logFormCountry = convertCountry(shortCountry);

            actual.add(logFormCountry);

            actual.add(convertDate(rs.getString("client_birthdate")));

            actual.add(genderConversion(rs.getString("client_gender")));

            actual.add(rs.getString("client_phone"));
            actual.add(rs.getString("client_fax"));
            actual.add(rs.getString("client_mobile"));
            actual.add(rs.getString("client_email"));
            actual.add(rs.getString("client_web"));
            actual.add(rs.getString("client_vat_id"));
            actual.add(rs.getString("client_tax_code"));

        }


        Assert.assertEquals(actual,expected,"wrong entries in table");

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
