package org.example.models;

import org.example.model.*;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class PassengerTest {
    @Test
    public void addActivitySuccess() {
        Destination destination1 = new Destination("Destination 1");
        Activity activity1 = new Activity("Activity 1", "Description 1", 100.0, 2, destination1);
        destination1.addActivity(activity1);
        Passenger p1 = new Passenger("Ram", 1, PassengerType.STANDARD);
        p1.setBalance(100.0);
        p1.signUp(activity1);

        assertEquals(1, p1.getActivitiesSignedUp().size());
    }

    @Test
    public void addActivityFailure_LessBalance() {
        Destination destination1 = new Destination("Destination 1");
        Activity activity1 = new Activity("Activity 1", "Description 1", 100.0, 2, destination1);
        destination1.addActivity(activity1);
        Passenger p1 = new Passenger("Ram", 1, PassengerType.STANDARD);
        p1.setBalance(80);
        p1.signUp(activity1);

        assertEquals(0, p1.getActivitiesSignedUp().size());
    }

    @Test
    public void addActivitySuccess_Premium() {
        Destination destination1 = new Destination("Destination 1");
        Activity activity1 = new Activity("Activity 1", "Description 1", 100.0, 2, destination1);
        destination1.addActivity(activity1);
        Passenger p1 = new Passenger("Ram", 1, PassengerType.PREMIUM);
        p1.signUp(activity1);

        assertEquals(1, p1.getActivitiesSignedUp().size());
    }

    @Test
    public void testPrintPassenger() {
        Destination destination1 = new Destination("Destination 1");
        Activity activity1 = new Activity("Activity 1", "Description 1", 100.0, 2, destination1);
        destination1.addActivity(activity1);
        Passenger p1 = new Passenger("Ram", 1, PassengerType.STANDARD);
        p1.setBalance(200.0);
        p1.signUp(activity1);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        p1.printDetails();
        String expectedOutput = "Passenger Name: Ram" + System.lineSeparator() +
                "Passenger Number: 1" + System.lineSeparator() +
                "Passenger Type: STANDARD" + System.lineSeparator() +
                "Balance: $100.0" + System.lineSeparator() +
                "Activities Signed Up:" + System.lineSeparator() +
                "- Activity 1 at Destination 1 - Cost: $100.0" + System.lineSeparator();

        assertEquals(expectedOutput, outputStream.toString());
    }
}
