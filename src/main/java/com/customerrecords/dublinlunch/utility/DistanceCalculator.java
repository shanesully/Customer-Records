package com.customerrecords.dublinlunch.utility;

import org.springframework.stereotype.Component;

@Component
public class DistanceCalculator
{
    public double distanceInKm(
            double referenceLatitude, double referenceLongitude,
            double givenLatitude, double givenLongitude) {

        referenceLatitude = Math.toRadians(referenceLatitude);
        referenceLongitude = Math.toRadians(referenceLongitude);
        givenLatitude = Math.toRadians(givenLatitude);
        givenLongitude = Math.toRadians(givenLongitude);

        double theta = referenceLongitude - givenLongitude;
        double distance = (Math.sin(referenceLatitude) * Math.sin(givenLatitude)) + (Math.cos(referenceLatitude) * Math.cos(givenLatitude) * Math.cos(theta));

        distance = Math.acos(distance);
        distance = Math.toDegrees(distance);

        distance = convertDistanceInDegreesToNauticalMiles(distance);
        distance = convertDistanceInNauticalMilesToKm(distance);

        return distance;
    }

    private double convertDistanceInDegreesToNauticalMiles(double distanceInDegrees) {
        return distanceInDegrees * 60 * 1.1515;
    }

    private double convertDistanceInNauticalMilesToKm(double distanceInNauticalMiles) {
        return distanceInNauticalMiles * 1.609344;
    }
}
