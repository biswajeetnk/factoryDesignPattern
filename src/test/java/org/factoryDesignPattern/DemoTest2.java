package org.factoryDesignPattern;

import org.factoryDesignPattern.pageObject.TravelHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DemoTest2 extends BaseTest
{
    WebDriver driver;

    @BeforeTest
    public void setup()
    {
        driver = initialiseDrivers();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }


    @Test(description = "This is just test", dataProvider = "getData2")
    public void demoTest(HashMap<String, String> reservationDetailsUsingHashMap)
    {
        TravelHomePage travelHomePage = new TravelHomePage(driver);
        travelHomePage.goTo();
        travelHomePage.setBookingStrategy("roundTrip");

        HashMap<String, String> reservationDetails = new HashMap<String, String>();
        //System.out.println("Without using data provider");
        reservationDetails.put("origin", "HYDERABAD");
        reservationDetails.put("destination", "DELHI");
        travelHomePage.checkAvailability(reservationDetails);

        System.out.println();
        System.out.println("**********************************");
        //System.out.println("Using data provider");

        travelHomePage.checkAvailability(reservationDetailsUsingHashMap);
    }
        //using above hardcoded values with using HashMap/DataProvider :
        @DataProvider
        public Object[][] getData()
        {
            HashMap<String, String> reservationDetailsUsingDataProvider1 = new HashMap<String, String>();
            reservationDetailsUsingDataProvider1.put("origin", "PUNE");
            reservationDetailsUsingDataProvider1.put("destination","BANGALORE");
            HashMap<String, String> reservationDetailsUsingDataProvider2 = new HashMap<String, String>();
            reservationDetailsUsingDataProvider2.put("origin", "BHUBANESHWAR");
            reservationDetailsUsingDataProvider2.put("destination","MUMBAI");

            return new Object[][]
            {
                {reservationDetailsUsingDataProvider1},
                    {reservationDetailsUsingDataProvider2}

            };
        }

    //using above hardcoded values with using JSON :
    @DataProvider
    public Object[][] getData2() throws IOException
    {
        List<HashMap<String, String>> list = getJsonData(System.getProperty("user.dir")+"//src//test//java//org//factoryDesignPattern//DataLoaders//reservationDetails.json"); //user.dir -> gives path to the project level

        return new Object[][]
                {
                        {list.get(0)},
                        {list.get(1)}
                };
    }

        @AfterTest
        public void teardown()
        {
            driver.quit();
        }
}
