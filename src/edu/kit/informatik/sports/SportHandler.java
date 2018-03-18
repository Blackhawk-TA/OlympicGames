package edu.kit.informatik.sports;

import java.util.ArrayList;
import java.util.List;

public class SportHandler {
    private final List<Discipline> disciplines = new ArrayList<>();

    /**
     * Adds a discipline and sport if one of them doesn't exist yet
     * @param sport The sport which the discipline belongs to
     * @param discipline The specific discipline
     * @return String, OK if successful, else error message
     */
    public String addDiscipline(String sport, String discipline) {
        if (getIndex(discipline) == -1) {
            disciplines.add(new Discipline(sport, discipline));
            return "OK";
        } else {
            return "Error, discipline already exists.";
        }
    }

    /**
     * Creates a list of all sports and disciplines
     * @return The list of sports and disciplines
     */
    public String listSports() {
        disciplines.sort((Discipline o1, Discipline o2) -> {
            if (o1.getSport().equals(o2.getSport()))
                return o1.getDiscipline().compareTo(o2.getDiscipline());
            else
                return o1.getSport().compareTo(o2.getSport());
        });

        StringBuilder output = new StringBuilder();
        for (Discipline item: disciplines) {
            output.append(String.format("%s %s\n", item.getSport(), item.getDiscipline()));
        }

        if (output.length() >= 1)
            output.setLength(output.length() - 1); //Remove last linebreak

        if (output.length() == 0)
            output.append("Error, no sports registered yet.");

        return output.toString();
    }

    /**
     * Get the index of the item where the requested discipline is located
     * @param discipline The discipline to search for
     * @return The discipline if found, else -1
     */
    private int getIndex(String discipline) {
        for (int i = 0; i < disciplines.size(); i++) {
            if (disciplines.get(i).getDiscipline().equals(discipline)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Get the discipline list
     * @return The discipline list
     */
    public List<Discipline> getDisciplines() {
        return disciplines;
    }
}
