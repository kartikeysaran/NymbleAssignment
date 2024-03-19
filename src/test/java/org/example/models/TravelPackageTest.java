package org.example.models;

import org.example.model.*;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TravelPackageTest {
    @Test
    public void testAddPassengerSuccess() {
        TravelPackage travelPackage = new TravelPackage("Test Package", 2);
        Passenger p1 = new Passenger("Ram", 1, PassengerType.GOLD);
        Passenger p2 = new Passenger("Kartikey", 2, PassengerType.STANDARD);

        travelPackage.addPassenger(p1);
        travelPackage.addPassenger(p2);

        assertEquals(2, travelPackage.getPassengers().size());
    }

    @Test
    public void testAddPassengerFail_capacityExceeded() {
        TravelPackage travelPackage = new TravelPackage("Test Package", 1);
        Passenger p1 = new Passenger("Ram", 1, PassengerType.GOLD);
        Passenger p2 = new Passenger("Kartikey", 2, PassengerType.STANDARD);

        travelPackage.addPassenger(p1);
        travelPackage.addPassenger(p2);

        assertEquals(1, travelPackage.getPassengers().size());
    }

    @Test
    public void testRemovePassenger() {
        TravelPackage travelPackage = new TravelPackage("Test Package", 2);
        Passenger p1 = new Passenger("Ram", 1, PassengerType.GOLD);
        Passenger p2 = new Passenger("Kartikey", 2, PassengerType.STANDARD);

        travelPackage.addPassenger(p1);
        travelPackage.addPassenger(p2);
        travelPackage.removePassenger(p1);

        List<Passenger> expectedPassengers = Arrays.asList(p2);
        assertEquals(1, travelPackage.getPassengers().size());
        assertEquals(expectedPassengers, travelPackage.getPassengers());
    }

    @Test
    public void testPrintItinerary() {
        TravelPackage travelPackage = new TravelPackage("Test Package", 2);
        Destination destination1 = new Destination("Destination 1");
        Activity activity1 = new Activity("Activity 1", "Description 1", 100.0, 10, destination1);
        destination1.addActivity(activity1);
        travelPackage.addItinerary(destination1);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        travelPackage.printItinerary();

        String expectedOutput = "Travel Package: Test Package" + System.lineSeparator() +
                "Destination: Destination 1" + System.lineSeparator() +
                "Activities:" + System.lineSeparator() +
                "- Activity 1: Cost - $100.0, Capacity - 10" + System.lineSeparator() + System.lineSeparator();

        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testPrintPassengerList() {
        TravelPackage travelPackage = new TravelPackage("Test Package", 2);
        Passenger p1 = new Passenger("Ram", 1, PassengerType.GOLD);
        Passenger p2 = new Passenger("Kartikey", 2, PassengerType.STANDARD);
        travelPackage.addPassenger(p1);
        travelPackage.addPassenger(p2);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        travelPackage.printPassengerList();

        String expectedOutput = "Passenger List for Travel Package: Test Package" + System.lineSeparator() +
                "Capacity: 2" + System.lineSeparator() +
                "Current Passengers: 2" + System.lineSeparator() +
                "- Ram (Passenger Number: 1)" + System.lineSeparator() +
                "- Kartikey (Passenger Number: 2)" + System.lineSeparator();

        assertEquals(expectedOutput, outputStream.toString());
    }
}
