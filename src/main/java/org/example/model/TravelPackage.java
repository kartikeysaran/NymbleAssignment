package org.example.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a travel package offered by a travel agency.
 * Each travel package has a name, passenger capacity, itinerary, and list of passengers.
 */
@Getter
@Setter
public class TravelPackage {
    private String name;
    private int passengerCapacity;
    private List<Destination> itinerary;
    private List<Passenger> passengers;

    /**
     * Constructs a TravelPackage object with the specified name and passenger capacity.
     *
     * @param name             The name of the travel package.
     * @param passengerCapacity The maximum number of passengers the package can accommodate.
     */
    public TravelPackage(String name, int passengerCapacity) {
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.itinerary = new ArrayList<>();
        this.passengers = new ArrayList<>();
    }

    /**
     * Adds a passenger to the travel package if there is space available.
     *
     * @param passenger The passenger to be added.
     */
    public void addPassenger(Passenger passenger) {
        if (passengers.size() < passengerCapacity) {
            passengers.add(passenger);
        } else {
            System.out.println("Cannot add passenger. Package is full.");
        }
    }

    /**
     * Removes a passenger from the travel package.
     *
     * @param passenger The passenger to be removed.
     */
    public void removePassenger(Passenger passenger) {
        passengers.remove(passenger);
    }

    /**
     * Adds a destination to the itinerary of the travel package.
     *
     * @param destination The destination to be added to the itinerary.
     */
    public void addItinerary(Destination destination) {
        itinerary.add(destination);
    }

    /**
     * Prints the itinerary of the travel package, including destinations and activities.
     * This method is for displaying purposes.
     */
    public void printItinerary() {
        System.out.println("Travel Package: " + name);
        for (Destination destination : itinerary) {
            System.out.println("Destination: " + destination.getName());
            System.out.println("Activities:");
            for (Activity activity : destination.getActivities()) {
                System.out.println("- " + activity.getName() + ": Cost - $" + activity.getCost() +
                        ", Capacity - " + activity.getCapacity());
            }
            System.out.println();
        }
    }

    /**
     * Prints the list of passengers booked for the travel package.
     * This method is for displaying purposes.
     */
    public void printPassengerList() {
        System.out.println("Passenger List for Travel Package: " + name);
        System.out.println("Capacity: " + passengerCapacity);
        System.out.println("Current Passengers: " + passengers.size());
        for (Passenger passenger : passengers) {
            System.out.println("- " + passenger.getName() + " (Passenger Number: " + passenger.getPassengerNumber() + ")");
        }
    }
}
