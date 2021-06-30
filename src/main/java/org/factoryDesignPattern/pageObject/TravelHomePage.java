package org.factoryDesignPattern.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.factoryDesignPattern.abstractComponent.SearchFlightAvail;
import org.factoryDesignPattern.abstractComponent.StrategyFactor;
import org.factoryDesignPattern.pageComponents.FooterNav;
import org.factoryDesignPattern.pageComponents.NavigationBar;

import java.util.HashMap;

public class TravelHomePage
{
    /*URL : https://rahulshettyacademy.com/dropdownsPractise/*/

    WebDriver driver;
    By footer = By.id("traveller-home");
    By navigationBar = By.id("buttons");
    SearchFlightAvail searchFlightAvail;

    public TravelHomePage(WebDriver driver)
    {
        this.driver = driver;
    }

   public void goTo()
    {
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }

    public NavigationBar getNavigationBar()
    {
        return new NavigationBar(driver, navigationBar);
    }

    public FooterNav getFooterNav()
    {
        return new FooterNav(driver, footer);
    }

    public void setBookingStrategy(String strategyType)
    //since SearchFlightAvail is the common interface for all the classes in pageComponenets
    // hence we can use it for MultiTrip and RoundTrip also.
    //the strategy to use either MultiTrip or RoundTrip is set in DemoTest.java class
    {
        StrategyFactor strategyFactor = new StrategyFactor(driver);
        searchFlightAvail = strategyFactor.createStrategy(strategyType);
        this.searchFlightAvail = searchFlightAvail;
    }

    public void checkAvailability(HashMap<String, String> reservationDetails)
    {
        searchFlightAvail.checkAvailability(reservationDetails);
    }
}
