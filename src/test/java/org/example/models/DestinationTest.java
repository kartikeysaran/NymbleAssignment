package org.example.models;
import org.example.model.Activity;
import org.example.model.Destination;
import org.example.model.Passenger;
import org.example.model.PassengerType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class DestinationTest {

    @Test
    public void testAddActivity() {
        Destination destination = new Destination("Ayodhya");
        Activity activity1 = new Activity("Visit Ram Mandir", "Temple", 50.0, 100, destination);
        Activity activity2 = new Activity("Explore Hanuman Gadhi", "Temple", 40.0, 80, destination);

        destination.addActivity(activity1);
        destination.addActivity(activity2);

        List<Activity> activities = destination.getActivities();
        assertEquals(2, activities.size());
        assertTrue(activities.contains(activity1));
        assertTrue(activities.contains(activity2));
    }

    @Test
    public void testRemoveActivity() {
        Destination destination = new Destination("Rome");
        Activity activity1 = new Activity("Visit Colosseum", "Ancient amphitheater", 60.0, 120, destination);
        Activity activity2 = new Activity("Explore Vatican Museums", "Art and history museum", 50.0, 100, destination);

        destination.addActivity(activity1);
        destination.addActivity(activity2);

        destination.removeActivity(activity1);

        List<Activity> activities = destination.getActivities();
        assertEquals(1, activities.size());
        assertFalse(activities.contains(activity1));
        assertTrue(activities.contains(activity2));
    }

    @Test
    public void testGetAvailableActivities() {
        Destination destination = new Destination("London");
        Activity activity1 = new Activity("Visit Tower of London", "Historic castle", 30.0, 1, destination);
        Activity activity2 = new Activity("Explore British Museum", "Art and culture museum", 25.0, 2, destination);

        destination.addActivity(activity1);
        destination.addActivity(activity2);

        Passenger p1 = new Passenger("Ram", 1, PassengerType.PREMIUM);
        Passenger p2 = new Passenger("Kartikey", 2, PassengerType.PREMIUM);
        activity1.signUp(p1);
        activity2.signUp(p1);
        activity2.signUp(p2);

        List<Activity> availableActivities = destination.getAvailableActivities();
        assertEquals(0, availableActivities.size()); // Both activities are fully booked

        // Add a new activity
        Activity activity3 = new Activity("Visit Buckingham Palace", "Royal residence", 40.0, 80, destination);
        destination.addActivity(activity3);

        availableActivities = destination.getAvailableActivities();
        assertEquals(1, availableActivities.size());
        assertTrue(availableActivities.contains(activity3));
    }
}