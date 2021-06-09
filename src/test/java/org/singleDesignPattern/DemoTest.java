package org.singleDesignPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.singleDesignPattern.abstractComponent.SearchFlightAvail;
import org.singleDesignPattern.pageComponents.MultiTrip;
import org.singleDesignPattern.pageComponents.RoundTrip;
import org.singleDesignPattern.pageObject.TravelHomePage;
import org.testng.annotations.Test;

public class DemoTest
{
    By sectionElement = By.id("flightSearchContainer");

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

        //for strategy design pattern - lets have 3 classes for flight booking : one-way, round-trip, multi-trip
        //so whenever we select 'one-way' then all the methods related to that will go with that, similarly with 'round-trip' and 'multi-trip'
        //example : travelHomePage.getLinksCount("footer"), travelHomepage.getLinksCount("header"), travelHomePage.checkAvailability("multiTrip")
        //we are passing parameters/algorithms in method - runtime instructions

        //the strategy to use either MultiTrip or RoundTrip is set,
        //so now the next step "travelHomePage.checkAvailability" will go to 'MultiTrip' page
        //if we set 'RoundTrip' strategy then it will go 'RoundTrip' page
        travelHomePage.setBookingStrategy(new MultiTrip());
        travelHomePage.checkAvailability("origin","destination");

        travelHomePage.setBookingStrategy(new RoundTrip(driver, sectionElement));
        travelHomePage.checkAvailability("Goa","Adampur");


    }
}
