package edu.kit.informatik.competition;

class Competition {
    private final String id;
    private final int year;
    private final String country;
    private final String sport;
    private final String discipline;
    private final int gold;
    private final int silver;
    private final int bronze;

    /**
     * Constructor of the competition
     * @param id The id of the athlete
     * @param year The year the athlete took part
     * @param country The country of the athlete
     * @param sport The sport the athlete is doing
     * @param discipline The discipline the athlete is taking part in
     * @param gold Represents the amount of gold medals the athlete has won
     * @param silver Represents the amount of silver medals the athlete has won
     * @param bronze Represents the amount of bronze medals the athlete has won
     */
    Competition(String id, int year, String country, String sport, String discipline,
                int gold, int silver, int bronze) {
        this.id = id;
        this.year = year;
        this.country = country;
        this.sport = sport;
        this.discipline = discipline;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
    }

    /**
     * Get the id of the competition
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     * Get the year the athlete took part
     * @return The year
     */
    int getYear() {
        return year;
    }

    /**
     * Get the country of the athlete
     * @return The country
     */
    String getCountry() {
        return country;
    }

    /**
     * Get the sport the athlete is doing
     * @return The sport
     */
    String getSport() {
        return sport;
    }

    /**
     * Get the discipline the athlete is taking part in
     * @return The discipline
     */
    String getDiscipline() {
        return discipline;
    }

    /**
     * Get the amount of gold medals of the athlete
     * @return The amount of gold medals
     */
    public int getGold() {
        return gold;
    }

    /**
     * Get the amount of silver medals of the athlete
     * @return The amount of silver medals
     */
    public int getSilver() {
        return silver;
    }

    /**
     * Get the amount of bronze medals of the athlete
     * @return The amount of bronze medals
     */
    public int getBronze() {
        return bronze;
    }
}
