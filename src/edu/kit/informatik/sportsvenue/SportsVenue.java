package edu.kit.informatik.sportsvenue;

class SportsVenue {
    private final String id;
    private final String country;
    private final String location;
    private final String name;
    private final int openingYear;
    private final int seats;

    /**
     * Constructor for the sports venue
     * @param id The id of the sports venue
     * @param country The country name
     * @param location The location
     * @param name The name of the venue
     * @param openingYear The year when the sports venue first opened
     * @param seats The amount of seat available
     */
    SportsVenue(String id, String country, String location, String name, int openingYear, int seats) {
        this.id = id;
        this.country = country;
        this.location = location;
        this.name = name;
        this.openingYear = openingYear;
        this.seats = seats;
    }
}
