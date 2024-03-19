package org.example.models;

import org.example.model.Activity;
import org.example.model.Destination;
import org.example.model.Passenger;
import org.example.model.PassengerType;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class ActivityTest {

    private static final double DELTA = 0.0001;

    @Test
    public void testSignUpSuccess() {
        Destination destination = new Destination("Paris");
        Activity activity = new Activity("Visit Eiffel Tower", "Iconic landmark", 50.0, 100, destination);
        Passenger passenger = new Passenger("John Doe", 1, PassengerType.STANDARD);

        boolean signedUp = activity.signUp(passenger);

        assertTrue(signedUp);
        assertEquals(1, activity.getSignedUp());
        assertEquals(99, activity.getAvailableCapacity(), DELTA);
    }

    @Test
    public void testSignUpCapacityFull() {
        Destination destination = new Destination("Rome");
        Activity activity = new Activity("Explore Colosseum", "Ancient amphitheater", 60.0, 2, destination);
        Passenger passenger1 = new Passenger("Jane Smith", 2, PassengerType.GOLD);
        Passenger passenger2 = new Passenger("Alice Johnson", 3, PassengerType.STANDARD);

        // Fully book the activity
        activity.signUp(passenger1);
        activity.signUp(passenger2);

        // Try to sign up another passenger
        Passenger newPassenger = new Passenger("Bob Brown", 4, PassengerType.STANDARD);
        boolean signedUp = activity.signUp(newPassenger);

        assertFalse(signedUp);
        assertEquals(2, activity.getSignedUp());
        assertEquals(0, activity.getAvailableCapacity(),DELTA);
    }

    @Test
    public void testGetAvailableCapacity() {
        Destination destination = new Destination("London");
        Activity activity = new Activity("Visit Tower of London", "Historic castle", 30.0, 50, destination);

        activity.signUp(new Passenger("John", 1, PassengerType.PREMIUM));
        activity.signUp(new Passenger("Jane", 2, PassengerType.GOLD));
        activity.signUp(new Passenger("Alice", 3, PassengerType.STANDARD));

        assertEquals(47, activity.getAvailableCapacity(), DELTA);
    }
}
