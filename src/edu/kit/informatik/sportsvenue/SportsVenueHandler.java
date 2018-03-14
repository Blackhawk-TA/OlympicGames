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
     * @return String containing "OK" if successful
     */
    public String addSportsVenue(String id, String country, String location, String name, int openingYear, int seats) {
        sportsVenues.add(new SportsVenue(id, country, location, name, openingYear, seats));
        return "OK";
    }

    /**
     * Lists the sport venues of a specific country
     * @param country The country
     * @return A list of sport venues of the requested country
     */
    public String listSportVenues(String country) {
        return "";
    }
}
