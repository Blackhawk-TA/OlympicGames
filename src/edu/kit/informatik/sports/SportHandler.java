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
        return "";
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
}
