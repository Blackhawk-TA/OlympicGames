package edu.kit.informatik.ioc;

public class Ioc {
    private final String id;
    private final String code;
    private final String country;
    private final Integer year;

    /**
     * Constructor for IOC codes
     * @param id The id of the code
     * @param code The code itself
     * @param country The country which the code stands for
     * @param year The year the code has been added
     */
    Ioc(String id, String code, String country, Integer year) {
        this.id = id;
        this.code = code;
        this.country = country;
        this.year = year;
    }

    /**
     * Get the ioc id
     * @return The id of the ioc
     */
    public String getId() {
        return id;
    }

    /**
     * Get the ioc code
     * @return The ioc code of the country
     */
    public String getCode() {
        return code;
    }

    /**
     * Get the country of a ioc code
     * @return The country which the ioc code refers to
     */
    public String getCountry() {
        return country;
    }

    /**
     * Get the year the ioc has been introduced
     * @return The year
     */
    public Integer getYear() {
        return year;
    }
}
