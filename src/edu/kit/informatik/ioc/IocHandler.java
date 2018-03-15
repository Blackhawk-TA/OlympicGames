package edu.kit.informatik.ioc;

import java.util.ArrayList;
import java.util.List;

public class IocHandler {
    private final List<Ioc> ioc = new ArrayList<>();

    /**
     * Add an ioc for a country
     * @param id The id of the code
     * @param code The code itself
     * @param country The country which the code stands for
     * @param year The year the code has been added
     * @return String containing "OK" if successful and error message if not
     */
    public String addIOC(String id, String code, String country, int year) {
        if (getIndex(code) == -1) {
            ioc.add(new Ioc(id, code, country, year));
            return "OK";
        } else {
            return "Error, this athlete already exists.";
        }
    }

    /**
     * Get the index of the item where the requested id is located
     * @param id The id to search for
     * @return The id if found, else -1
     */
    public int getIndex(String id) {
        for (int i = 0; i < ioc.size(); i++) {
            if (ioc.get(i).getCode().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Get the IOC of a country
     * @param country The country the IOC is searched for
     * @return The to the country referring IOC
     */
    public String toIOC(String country) {
        for (Ioc item: ioc) {
            if (item.getCountry().equals(country)) {
                return item.getCode();
            }
        }
        return "";
    }
}
