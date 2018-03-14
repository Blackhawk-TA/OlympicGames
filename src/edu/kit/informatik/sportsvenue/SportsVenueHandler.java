package edu.kit.informatik.sportsvenue;

import java.util.ArrayList;
import java.util.List;

public class SportsVenueHandler {
    private List<SportsVenue> sportsVenues = new ArrayList<>();

    /**
     * Add a sports venue
     * @param id The id of the sports venue
     * @param country The country name
     * @param location The location
     * @param name The name of the venue
     * @param openingYear The year when the sports venue first opened
     * @param seats The amount of seat available
     * @return String containing "OK" if successful and error message if not
     */
    public String addSportsVenue(String id, String country, String location, String name, int openingYear, int seats) {
        if (getIndex(id) == -1) {
            sportsVenues.add(new SportsVenue(id, country, location, name, openingYear, seats));
            return "OK";
        } else {
            return "Error, this sports venue already exists.";
        }
    }

    /**
     * Lists the sport venues of a specific country
     * @param country The country
     * @return A list of sport venues of the requested country
     */
    public String listSportVenues(String country) {
        return "";
    }


    /**
     * Get the index of the item where the requested id is located
     * @param id The id to search for
     * @return The id if found, else -1
     */
    private int getIndex(String id) {
        for (int i = 0; i < sportsVenues.size(); i++) {
            if (sportsVenues.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}
