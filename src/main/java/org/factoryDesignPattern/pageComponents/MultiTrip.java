package org.factoryDesignPattern.pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.factoryDesignPattern.abstractComponent.SearchFlightAvail;

import java.util.HashMap;

public class MultiTrip implements SearchFlightAvail
{

    public MultiTrip(WebDriver driver, By sectionElement)
    {
        //super(driver, sectionElement);
    }

    @Override
    public void checkAvailability(HashMap<String, String> reservationDetails)
    {
        System.out.println("I am inside multi trip");
    }
}
