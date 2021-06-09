package org.singleDesignPattern.pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.singleDesignPattern.abstractComponent.AbstractComponent;

public class NavigationBar extends AbstractComponent
{
    WebDriver driver;

    By flightInHeader = By.cssSelector("[title='Flights']"); //same CSS as in footer
    By links = By.cssSelector("a");

    public NavigationBar(WebDriver driver, By navigationBar)
    {
        super(driver, navigationBar);
    }
    //to access this method from any test code should be TravelHomePage.getNavigationBar().anyMethodName in this Page

    public String selectFlightInHeader()
    {
        //it should be in format : footer.findElement.flight -- it will select ONLY flight in footer.
        //So we have to create a reusable method to achieve that
        return findElement(flightInHeader).getAttribute("class");
        //findElement(flightInFooter).click();
        //driver.findElement(footer).click();
    }

    public int getLinkCount()
    {
        return findElements(links).size();
    }
}
