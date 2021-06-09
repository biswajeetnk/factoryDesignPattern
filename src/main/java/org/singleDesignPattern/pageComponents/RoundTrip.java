package org.singleDesignPattern.pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.singleDesignPattern.abstractComponent.AbstractComponent;
import org.singleDesignPattern.abstractComponent.SearchFlightAvail;

public class RoundTrip extends AbstractComponent implements SearchFlightAvail
{

    private By radioButton = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    //private By selectFromCity = By.xpath("//a[contains(text(),'Guwahati')]");
    private By checkBox = By.id("ctl00_mainContent_IndArm");
    private By searchButton = By.id("ctl00_mainContent_btn_FindFlights");

    public RoundTrip(WebDriver driver, By flights)
    {
        super(driver, flights);
    }

    @Override
    public void checkAvailability(String origin, String destination)
    {
        System.out.println("I am inside round trip");
        findElement(radioButton).click();
        //findElement(selectFromCity).click();
        selectOriginCity(origin);
        selectDestinationCity(destination);
        findElement(checkBox).click();
        findElement(searchButton).click();
    }

    public void selectOriginCity(String origin)
    {
        findElement(By.xpath("//a[contains(text(),'"+origin+"')]")).click();
    }

    public void selectDestinationCity(String destination)
    {
        findElement((By.xpath("(//a[contains(text(),'"+destination+"')])[2]"))).click();
    }
}
