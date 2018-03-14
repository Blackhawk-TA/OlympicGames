package edu.kit.informatik.sports;

import edu.kit.informatik.listUtils.ListUtils;

import java.util.ArrayList;
import java.util.List;

public class SportHandler {
    private final List<String> disciplines = new ArrayList<>();

    /**
     * Adds a discipline and sport if one of them doesn't exist yet
     * @param sport The sport which the discipline belongs to
     * @param discipline The specific discipline
     * @return String, OK if successful, else error message
     */
    public String addDiscipline(String sport, String discipline) {
        int disciplineId = ListUtils.getIndexByName(disciplines, discipline);
        if (disciplineId == -1) {
            disciplines.add(discipline);
            return "OK";
        } else {
            return "Error, discipline already exists.";
        }
    }

    /**
     * Creates a list of all sports and disciplines
     * @return The list of sports and disciplines
     */
    public String listDisciplines() {
        return "";
    }
}
