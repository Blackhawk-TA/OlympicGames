package edu.kit.informatik.ioc;

class Ioc {
    private final String id;
    private final String code;
    private final String country;
    private final int year;

    /**
     * Constructor for IOC codes
     * @param id The id of the code
     * @param code The code itself
     * @param country The country which the code stands for
     * @param year The year the code has been added
     */
    Ioc(int id, String code, String country, int year) {
        this.id = String.format("%03d", id);
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
    String getCode() {
        return code;
    }

    /**
     * Get the country of a ioc code
     * @return The country which the ioc code refers to
     */
    String getCountry() {
        return country;
    }
}
