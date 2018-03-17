package edu.kit.informatik.competition;

class MedalTable {
    private final String iocId;
    private final String ioc;
    private final String country;
    private final Integer gold;
    private final Integer silver;
    private final Integer bronze;
    private final int medals;

    /**
     * Constructor for the olympic medal table
     * @param iocId The IOC ID
     * @param ioc The IOC code
     * @param country The country
     * @param gold The amount of gold medals
     * @param silver The amount of silver medals
     * @param bronze The amount of bronze medals
     */
    MedalTable(String iocId, String ioc, String country, Integer gold, Integer silver, Integer bronze) {
        this.iocId = iocId;
        this.ioc = ioc;
        this.country = country;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
        this.medals = gold + silver + bronze;
    }

    /**
     * Get the IOC ID
     * @return The IOC ID
     */
    String getIocId() {
        return iocId;
    }

    /**
     * Get the IOC code
     * @return The IOC code
     */
    String getIoc() {
        return ioc;
    }

    /**
     * Get the country
     * @return The country
     */
    String getCountry() {
        return country;
    }

    /**
     * Get the overall amount of gold medals earned by the country
     * @return The amount of gold medals
     */
    Integer getGold() {
        return gold;
    }

     /**
     * Get the overall amount of silver medals earned by the country
     * @return The amount of silver medals
     */
     Integer getSilver() {
        return silver;
    }

     /**
     * Get the overall amount of bronze medals earned by the country
     * @return The amount of bronze medals
     */
     Integer getBronze() {
        return bronze;
    }

    /**
     * Get the overall amount of medals earned by the country
     * @return The amount of medals
     */
    int getMedals() {
        return medals;
    }
}
