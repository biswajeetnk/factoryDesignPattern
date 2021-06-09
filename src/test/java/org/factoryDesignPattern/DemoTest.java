package org.factoryDesignPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.factoryDesignPattern.pageObject.TravelHomePage;
import org.testng.annotations.Test;

public class DemoTest
{
    @Test
    public void demoTest()
    {
        System.setProperty("webdriver.chrome.driver","C://chromedriver_win32//chromedriver_ver90//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        TravelHomePage travelHomePage = new TravelHomePage(driver);
        travelHomePage.goTo();
        System.out.println(travelHomePage.getFooterNav().selectFlightInFooter()); //we are getting object of the FooterNav class by using getFoortNav()
                                                              //and using the selectFlightInFooter() method
        System.out.println(travelHomePage.getNavigationBar().selectFlightInHeader());
        System.out.println("The links count in header : "+travelHomePage.getNavigationBar().getLinkCount());
        System.out.println("The links count in footer : "+travelHomePage.getFooterNav().getLinkCount());

        //factory design pattern
        travelHomePage.setBookingStrategy("roundTrip");
        travelHomePage.checkAvailability("origin","destination");

        /*travelHomePage.setBookingStrategy(new RoundTrip(driver, sectionElement));
        travelHomePage.checkAvailability("Goa","Adampur");*/


    }
}
