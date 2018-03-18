package edu.kit.informatik.athletes;

import edu.kit.informatik.core.Core;
import edu.kit.informatik.ioc.Ioc;

import java.util.ArrayList;
import java.util.List;

public class AthleteHandler {
    private List<Athlete> athletes = new ArrayList<>();

    /**
     * Add an athlete to the system
     * @param id The id of the athlete
     * @param firstName The first name of the athlete
     * @param lastName The last name of the athlete
     * @param country The country of the athlete
     * @param sport The sport the athlete is doing
     * @param discipline The discipline the athlete is doing
     * @return String, OK if successful, else error message
     */
    public String addAthlete(String id, String firstName, String lastName, String country,
                             String sport, String discipline) {
        if (idNotUsed(id) && iocExists(country)) {
            athletes.add(new Athlete(id, firstName, lastName, country, sport, discipline));
            return "OK";
        } else if (!iocExists(country) && idNotUsed(id)) {
            return "Error, this country isn't registered in the IOC list.";
        } else {
            return "Error, this athlete already exists.";
        }
    }

    /**
     * Create a summary of athletes
     * @param sport The sport they are doing
     * @param discipline The discipline they are doing
     * @return A formatted String list containing the summary
     */
    public String summaryAthletes(String sport, String discipline) {
        athletes.sort((Athlete o1, Athlete o2) -> {
            if (o1.getMedals().equals(o2.getMedals()))
                return o1.getId().compareTo(o2.getId());
            else
                return o2.getMedals().compareTo(o1.getMedals());
        });

        StringBuilder output = new StringBuilder();
        for (Athlete item: athletes) {
            if (item.getSport().equals(sport) && item.getDiscipline().equals(discipline)) {
                output.append(String.format(
                        "%s %s %s %s\n", item.getId(), item.getFirstName(), item.getLastName(), item.getMedals()));
            }
        }

        if (output.length() >= 1)
            output.setLength(output.length() - 1); //Remove last linebreak

        if (output.length() == 0)
            output.append("Error, no athletes registered yet.");


        return output.toString();
    }

    /**
     * Get the index of the item where the requested id is located
     * @param id The id to search for
     * @return The id if found, else -1
     */
    private boolean idNotUsed(String id) {
        for (Athlete athlete: athletes) {
            if (athlete.getId().equals(id)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Get the IOC of a country
     * @param country The country the IOC is searched for
     * @return The to the country referring IOC
     */
    private boolean iocExists(String country) {
        for (Ioc item: Core.getIocHandler().getIocList()) {
            if (item.getCountry().equals(country)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Get the athlete list
     * @return The athlete list
     */
    public List<Athlete> getAthletes() {
        return athletes;
    }

    /**
     * Reset the list
     */
    public void reset() {
        athletes = new ArrayList<>();
    }
}
