package utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Conversion {

    public static String convertCountry(String shortCountry)
    {
        String convertedCountry="";

        switch (shortCountry)
        {
            case "IN" : convertedCountry ="India";break;
            case "CN" : convertedCountry ="China";break;
            case "AF" : convertedCountry ="Afghanistan";break;
            case "AQ" : convertedCountry ="Antarctica";break;
        }

        return  convertedCountry;
    }


    public static  String convertDate(String dbDate) throws ParseException // yyyy-MM-dd
    {
        String convertedDate ="";

        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dbDate);

        convertedDate = new SimpleDateFormat("dd/MM/yyyy").format(date);

        return convertedDate;

    }


    public static String genderConversion(String genderId)
    {
        String convertedGender="";


        switch (genderId)
        {
            case "0" : convertedGender="Male";break;
            case "1" : convertedGender="Female";break;
            case "2" : convertedGender="Other";break;
        }


        return  convertedGender;
    }
}
