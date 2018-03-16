package edu.kit.informatik.sportsvenue;

class SportsVenue {
    private final Integer id;
    private final String country;
    private final String location;
    private final String name;
    private final int openingYear;
    private final Integer seats;

    /**
     * Constructor for the sports venue
     * @param id The id of the sports venue
     * @param country The country name
     * @param location The location
     * @param name The name of the venue
     * @param openingYear The year when the sports venue first opened
     * @param seats The amount of seat available
     */
    SportsVenue(Integer id, String country, String location, String name, int openingYear, Integer seats) {
        this.id = id;
        this.country = country;
        this.location = location;
        this.name = name;
        this.openingYear = openingYear;
        this.seats = seats;
    }

    /**
     * Get the id of the sports venue
     * @return The id of the sports venue
     */
    Integer getId() {
        return id;
    }

    /**
     * Get the country where the sports venue is located
     * @return The country where the sports venue is located
     */
    String getCountry() {
        return country;
    }

    /**
     * Get the location of the sports venue
     * @return The location of the sports venue
     */
    String getLocation() {
        return location;
    }

    /**
     * Get the name of the sports venue
     * @return The name of the sports venue
     */
    String getName() {
        return name;
    }

    /**
     * Get the opening year of the sports venue
     * @return The opening year of the sports venue
     */
    int getOpeningYear() {
        return openingYear;
    }

    /**
     * Get the amount of seats of the sports venue
     * @return The amount of seats of the sports venue
     */
    Integer getSeats() {
        return seats;
    }
}
