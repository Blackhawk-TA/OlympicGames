package edu.kit.informatik.sportsvenue;

import edu.kit.informatik.ioc.IocHandler;

import java.util.ArrayList;
import java.util.Comparator;
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
    public String addSportsVenue(Integer id, String country, String location, String name,
                                 int openingYear, Integer seats) {
        IocHandler handler = new IocHandler();
        int iocExists = handler.getIndex(handler.toIOC(country));
        if (getIndex(id) == -1 && iocExists != -1) {
            sportsVenues.add(new SportsVenue(id, country, location, name, openingYear, seats));
            return "OK";
        } else if (iocExists == -1) {
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
    public String listSportVenues(String country) { //TODO add sorting
        sportsVenues.sort(new Comparator<SportsVenue>() {
            @Override
            public int compare(SportsVenue o1, SportsVenue o2) {
                if (o1.getSeats().equals(o2.getSeats())) {
                    return o1.getId().compareTo(o2.getId());
                } else {
                    return o1.getSeats().compareTo(o2.getSeats());
                }
            }
        });


        StringBuilder output = new StringBuilder();
        int index = 0;

        for (SportsVenue item: sportsVenues) {
            if (item.getCountry().equals(country)) {
                index++;

                //Create output line
                String ln = "(" + index + " " + item.getId() + " " + item.getLocation() + " " + item.getSeats() + ")\n";
                output.append(ln);
            }
        }
        //output.setLength(output.length() - 2); //Remove last linebreak
        //Comparator.comparing(SportsVenue::getSeats);

        return output.toString();
    }


    /**
     * Get the index of the item where the requested id is located
     * @param id The id to search for
     * @return The id if found, else -1
     */
    private Integer getIndex(int id) {
        for (int i = 0; i < sportsVenues.size(); i++) {
            if (sportsVenues.get(i).getId().equals(String.format("%03d", id))) {
                return i;
            }
        }
        return -1;
    }
}
