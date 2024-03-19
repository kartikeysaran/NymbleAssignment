package org.example.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Destination available in a travel package.
 * Each Destiation has a name and a list of activities
 */
@Getter
@Setter
public class Destination {
    private String name;
    private List<Activity> activities;

    /**
     * Constructs a Destination object with the specified details.
     * @param name The name of the Destination
     */
    public Destination(String name) {
        this.name = name;
        this.activities = new ArrayList<>();
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    /**
     * Calculates and returns the list of activities that are available (i.e. have capacity greater than 0)
     * @return The List of available activities
     */
    public List<Activity> getAvailableActivities() {
        List<Activity> availableActivities = new ArrayList<>();
        for (Activity activity : activities) {
            if (activity.getAvailableCapacity() > 0) {
                availableActivities.add(activity);
            }
        }
        return availableActivities;
    }
}
