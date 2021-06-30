package org.factoryDesignPattern.abstractComponent;

import java.util.HashMap;

public interface SearchFlightAvail
{
    void checkAvailability(HashMap<String, String> reservationDetails);
}
