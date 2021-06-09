package org.factoryDesignPattern.pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.factoryDesignPattern.abstractComponent.SearchFlightAvail;

public class MultiTrip implements SearchFlightAvail
{

    public MultiTrip(WebDriver driver, By sectionElement)
    {
        //super(driver, sectionElement);
    }

    @Override
    public void checkAvailability(String origin, String destination)
    {
        System.out.println("I am inside multi trip");
    }
}
