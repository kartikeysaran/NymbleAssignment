package org.example.model;

import lombok.Getter;
import lombok.Setter;
/**
 * Represents an activity available in a travel package.
 * Each activity has a name, description, cost, capacity, destination, and the number of signed up passengers.
 */
@Getter
@Setter
public class Activity {
    private String name;
    private String description;
    private double cost;
    private int capacity;
    private Destination destination;
    private int signedUp;

    /**
     * Constructs an Activity object with the specified details.
     *
     * @param name        The name of the activity.
     * @param description The description of the activity.
     * @param cost        The cost of the activity.
     * @param capacity    The maximum capacity of passengers for the activity.
     * @param destination The destination where the activity takes place.
     */
    public Activity(String name, String description, double cost, int capacity, Destination destination) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.destination = destination;
        this.signedUp = 0;
    }

    /**
     * Allows a passenger to sign up for this activity.
     *
     * @param passenger The passenger who wants to sign up.
     * @return true if the sign-up was successful, false if the activity is already full.
     */
    public boolean signUp(Passenger passenger) {
        if (signedUp < capacity) {
            passenger.signUp(this);
            signedUp++;
            return true;
        } else {
            System.out.println("Activity " + name + " at " + destination.getName() + " is full.");
            return false;
        }
    }

    /**
     * Calculates and returns the available capacity for the activity.
     * @return The number of remaining available slots for passengers to sign up.
     */
    public double getAvailableCapacity() {
        return capacity - signedUp;
    }
}
