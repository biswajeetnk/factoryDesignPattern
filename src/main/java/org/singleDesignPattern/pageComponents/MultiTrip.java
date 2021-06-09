package org.singleDesignPattern.pageComponents;

import org.singleDesignPattern.abstractComponent.SearchFlightAvail;

public class MultiTrip implements SearchFlightAvail
{

    @Override
    public void checkAvailability(String origin, String destination)
    {
        System.out.println("I am inside multi trip");
    }
}
