package edu.kit.informatik.ioc;

import java.util.ArrayList;
import java.util.List;

public class IocHandler {
    private final List<Ioc> iocs = new ArrayList<>();

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
            iocs.add(new Ioc(id, code, country, year));
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
    private int getIndex(String id) {
        for (int i = 0; i < iocs.size(); i++) {
            if (iocs.get(i).getCode().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}
