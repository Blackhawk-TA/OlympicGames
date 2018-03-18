package edu.kit.informatik.ioc;

import java.util.ArrayList;
import java.util.List;

public class IocHandler {
    private List<Ioc> iocList = new ArrayList<>();

    /**
     * Add an ioc for a country
     * @param id The id of the code
     * @param code The code itself
     * @param country The country which the code stands for
     * @param year The year the code has been added
     * @return String containing "OK" if successful and error message if not
     */
    public String addIOC(String id, String code, String country, Integer year) {
        if (getIndex(code) == -1 && getIdIndex(id) == -1 && getCountryIndex(country) == -1) {
            iocList.add(new Ioc(id, code, country, year));
            return "OK";
        } else {
            return "Error, this IOC already exists.";
        }
    }

    /**
     * Create a list of all IOC code
     * @return A formatted String with all IOC codes
     */
    public String listIOC() {
        iocList.sort((Ioc o1, Ioc o2) -> {
            if (o1.getYear().equals(o2.getYear()))
                return o1.getId().compareTo(o2.getId());
            else
                return o1.getYear().compareTo(o2.getYear());
        });

        StringBuilder output = new StringBuilder();
        for (Ioc item: iocList) {
            output.append(String.format(
                    "%d %s %s %s\n", item.getYear(), item.getId(), item.getCode(), item.getCountry()));
        }

        if (output.length() >= 1)
            output.setLength(output.length() - 1); //Remove last linebreak

        if (output.length() == 0)
            output.append("Error, no IOC codes registered yet.");

        return output.toString();
    }

    /**
     * Get the index of the item where the requested id is located
     * @param id The id to search for
     * @return The index of the id if found, else -1
     */
    private int getIdIndex(String id) {
        for (int i = 0; i < iocList.size(); i++) {
            if (iocList.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Get the index of the item where the requested country is located
     * @param country The country to search for
     * @return The index of the country if found, else -1
     */
    private int getCountryIndex(String country) {
        for (int i = 0; i < iocList.size(); i++) {
            if (iocList.get(i).getCountry().equals(country)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Get the index of the item where the requested code is located
     * @param code The code to search for
     * @return The index of the code if found, else -1
     */
    public int getIndex(String code) {
        for (int i = 0; i < iocList.size(); i++) {
            if (iocList.get(i).getCode().equals(code)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Get the IOC list
     * @return The IOC list
     */
    public List<Ioc> getIocList() {
        return iocList;
    }

    /**
     * Reset the list
     */
    public void reset() {
        iocList = new ArrayList<>();
    }

}
