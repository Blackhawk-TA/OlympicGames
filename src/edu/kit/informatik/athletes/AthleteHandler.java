package edu.kit.informatik.athletes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AthleteHandler {
    private final List<Athlete> athletes = new ArrayList<>();

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
    public String addAthlete(int id, String firstName, String lastName, String country,
                             String sport, String discipline) {
        if (getIndex(id) == -1) {
            athletes.add(new Athlete(id, firstName, lastName, country, sport, discipline));
            return "OK";
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
        athletes.sort(new Comparator<Athlete>() {
            @Override
            public int compare(Athlete o1, Athlete o2) {
                if (o1.getMedals().equals(o2.getMedals())) {
                    return o1.getId().compareTo(o2.getId());
                } else {
                    return o1.getMedals().compareTo(o2.getMedals());
                }
            }
        });


        StringBuilder output = new StringBuilder();
        int index = 0;

        for (Athlete item: athletes) {
            if (item.getSport().equals(sport) && item.getDiscipline().equals(discipline)) {
                //Create output line
                String ln = "(" + index + " " + item.getId() + " " + item.getFirstName() + " "
                                + item.getLastName() + item.getMedals() + ")\n";
                output.append(ln);
            }
        }
        if (output.length() >= 2)
            output.setLength(output.length() - 2); //Remove last linebreak
        //Comparator.comparing(SportsVenue::getSeats);

        return output.toString();
    }

    /**
     * Get the index of the item where the requested id is located
     * @param id The id to search for
     * @return The id if found, else -1
     */
    private int getIndex(int id) {
        for (int i = 0; i < athletes.size(); i++) {
            if (athletes.get(i).getId().equals(String.format("%04d", id))) {
                return i;
            }
        }
        return -1;
    }
}
