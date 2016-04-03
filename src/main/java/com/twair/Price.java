package com.twair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Price {
    public Double calculate(TravelClass travelClass, int numberOfSeats) {
        return travelClass.getEffectivePrice(numberOfSeats);
    }

    public Map<String, Double> calculate(List<Flight> flights, ClassType classType, int numberOfSeats) {
        Map<String, Double> priceMap = new HashMap<>();
        for(Flight flight : flights) {
            priceMap.put(flight.getNumber(), calculate(flight.getTravelClass(classType), numberOfSeats));
        }
        return priceMap;
    }
}
