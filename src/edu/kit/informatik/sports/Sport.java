package edu.kit.informatik.sports;

import edu.kit.informatik.listUtils.ListUtils;

import java.util.ArrayList;
import java.util.List;

class Sport {
    private final String name;
    private List<String> sports = new ArrayList<>();

    /**
     * Constructor for the sport
     * @param name The name of the sport
     */
    Sport(String name) {
        this.name = name;
        if (ListUtils.getIndexByName(sports, name) == -1) {
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
}
