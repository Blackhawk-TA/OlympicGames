package edu.kit.informatik.athletes;

public class Athlete {
    private final String id;
    private final String firstName;
    private final String lastName;
    private final String country;
    private final String sport;
    private final String discipline;
    private Integer medals;

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
        this.id = String.format("%04d", id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.sport = sport;
        this.discipline = discipline;
        this.medals = 0;
    }

    /**
     * Get the id of the athlete
     * @return The id in the patter 0001
     */
    public String getId() {
        return id;
    }

    /**
     * Get the first name of the athlete
     * @return The first name
     */
    String getFirstName() {
        return firstName;
    }

    /**
     * Get the last name of the athlete
     * @return The last name
     */
    String getLastName() {
        return lastName;
    }

    /**
     * Get the country the athlete is from
     * @return The country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Get the sport the athlete is doing
     * @return The sport
     */
    public String getSport() {
        return sport;
    }

    /**
     * Get the discipline the athlete is doing
     * @return The discipline
     */
    public String getDiscipline() {
        return discipline;
    }

    /**
     * Get the medals of the athlete
     * @return The medals the athlete has earned
     */
    Integer getMedals() {
        return medals;
    }

    /**
     * Add a medal to the athlete
     * @param amount Amount of medals to add
     */
    void addMedals(int amount) {
        medals += amount;
    }
}
