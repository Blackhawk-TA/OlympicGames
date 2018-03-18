package edu.kit.informatik.sports;

import java.util.ArrayList;
import java.util.List;

class Sport {
    private final String name;
    private final List<String> sports = new ArrayList<>();

    /**
     * Constructor for the sport
     * @param name The name of the sport
     */
    Sport(String name) {
        this.name = name;
        if (getIndex(name) == -1) {
            sports.add(name);
        }
    }

    /**
     * Get the name of the sport
     * @return The name of the sport
     */
    String getName() {
        return name;
    }

    /**
     * Get the list of sports
     * @return The list of sports
     */
    List<String> getSports() {
        return sports;
    }

    /**
     * Get the index of the item where the requested sport is located
     * @param sport The discipline to search for
     * @return The sport if found, else -1
     */
    private int getIndex(String sport) {
        for (int i = 0; i < sports.size(); i++) {
            if (sports.get(i).equals(sport)) {
                return i;
            }
        }
        return -1;
    }
}
