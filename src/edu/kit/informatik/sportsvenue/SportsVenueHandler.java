package edu.kit.informatik.sportsvenue;

import edu.kit.informatik.core.Core;
import edu.kit.informatik.ioc.Ioc;

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
    public String addSportsVenue(String id, String country, String location, String name,
                                 int openingYear, Integer seats) {
        if (getIndex(id) == -1 && iocExists(country)) {
            sportsVenues.add(new SportsVenue(id, country, location, name, openingYear, seats));
            return "OK";
        } else if (!iocExists(country)) {
            return "Error, IOC does not exist.";
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
        sportsVenues.sort((SportsVenue o1, SportsVenue o2) -> {
            if (o1.getSeats().equals(o2.getSeats()))
                return o1.getId().compareTo(o2.getId());
            else
                return o1.getSeats().compareTo(o2.getSeats());
        });

        StringBuilder output = new StringBuilder();
        int index = 0;

        for (SportsVenue item: sportsVenues) {
            if (item.getCountry().equals(country)) {
                index++;
                output.append(String.format(
                        "(%d %s %s %d)\n", index, item.getId(), item.getLocation(), item.getSeats()));
            }
        }

        if (output.length() >= 1)
            output.setLength(output.length() - 1); //Remove last linebreak

        if (output.length() == 0)
            output.append("Error, no sport venues registered yet.");

        return output.toString();
    }


    /**
     * Get the index of the item where the requested id is located
     * @param id The id to search for
     * @return The id if found, else -1
     */
    private Integer getIndex(String id) {
        for (int i = 0; i < sportsVenues.size(); i++) {
            if (sportsVenues.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Get the list of sport venues
     * @return The list of sport venues
     */
    public List<SportsVenue> getSportsVenues() {
        return sportsVenues;
    }

    /**
     * Reset the list
     */
    public void reset() {
        sportsVenues = new ArrayList<>();
    }

    /**
     * Get the IOC of a country
     * @param country The country the IOC is searched for
     * @return The to the country referring IOC
     */
    private boolean iocExists(String country) {
        for (Ioc item: Core.getIocHandler().getIocList()) {
            if (item.getCountry().equals(country)) {
                return true;
            }
        }
        return false;
    }
}
