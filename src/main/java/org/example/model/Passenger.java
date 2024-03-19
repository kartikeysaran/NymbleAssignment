package org.example.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Passenger available in Travel Package
 * Each Passenger has a name, passengerNumber, balance, passenger type, and list of activities passenger signed up for
 */
@Getter
@Setter
public class Passenger {
    private String name;
    private int passengerNumber;
    private double balance;
    private PassengerType passengerType;
    private List<Activity> activitiesSignedUp;

    public Passenger(String name, int passengerNumber, PassengerType passengerType) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.passengerType = passengerType;
        this.activitiesSignedUp = new ArrayList<>();
    }

    public boolean signUp(Activity activity) {
        double cost = passengerType == PassengerType.GOLD ? activity.getCost() * 0.9 : activity.getCost();
        if (passengerType == PassengerType.STANDARD || passengerType == PassengerType.GOLD) {
            if (balance >= cost) {
                balance -= cost;
                activitiesSignedUp.add(activity);
                return true;
            } else {
                System.out.println("Insufficient balance for " + name + " to sign up for activity " + activity.getName());
                return false;
            }
        } else {
            activitiesSignedUp.add(activity);
            return true;
        }
    }

    public double getCostForActivity(Activity activity) {
        return passengerType == PassengerType.GOLD ? activity.getCost() * 0.9 : activity.getCost();
    }

    /**
     * Prints the details of the Passenger
     */
    public void printDetails() {
        System.out.println("Passenger Name: " + name);
        System.out.println("Passenger Number: " + passengerNumber);
        System.out.println("Passenger Type: " + passengerType);
        if (passengerType == PassengerType.STANDARD || passengerType == PassengerType.GOLD) {
            System.out.println("Balance: $" + balance);
        }
        System.out.println("Activities Signed Up:");
        for (Activity activity : activitiesSignedUp) {
            System.out.println("- " + activity.getName() + " at " + activity.getDestination().getName() +
                    " - Cost: $" + getCostForActivity(activity));
        }
    }
}
