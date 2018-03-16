package edu.kit.informatik.athletes;

class Athlete {
    private final int id;
    private final String firstName;
    private final String lastName;
    private final String country;
    private final String sport;
    private final String discipline;

    /**
     * Constructor for athletes
     * @param id The id of the athlete
     * @param firstName The first name of the athlete
     * @param lastName The last name of the athlete
     * @param country The country of the athlete
     * @param sport The sport the athlete is doing
     * @param discipline The discipline the athlete is doing
     */
    Athlete(int id, String firstName, String lastName, String country, String sport, String discipline) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.sport = sport;
        this.discipline = discipline;
    }

    int getId() {
        return id;
    }
}
