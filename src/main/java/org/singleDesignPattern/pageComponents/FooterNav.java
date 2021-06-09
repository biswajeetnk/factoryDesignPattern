package org.singleDesignPattern.pageComponents;

import org.singleDesignPattern.abstractComponent.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FooterNav extends AbstractComponent
{
    WebDriver driver;
    //when selenium searches/executes any methods - then the scope should be limited to footer only.
    //If there are multiple elements in that page like in header also that should be ignored, it should execute the methdo of footer only.

    By flightInFooter = By.cssSelector("[title='Flights']");
    By links = By.cssSelector("a");

    public FooterNav(WebDriver driver, By footer)
    {
        super(driver, footer); //when we extend parent class, we should be inheriting constructor of parent class in child class constructor
    }

    public String selectFlightInFooter()
    {
        //it should be in format : footer.findElement.flight -- it will select ONLY flight in footer.
        //So we have to create a reusable method to achieve that
        return findElement(flightInFooter).getAttribute("class");
        //findElement(flightInFooter).click();
        //driver.findElement(footer).click();
    }

    public int getLinkCount()
    {
        return findElements(links).size();
    }
}
