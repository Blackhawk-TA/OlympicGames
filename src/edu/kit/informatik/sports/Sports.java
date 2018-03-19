package edu.kit.informatik.sports;

import java.util.ArrayList;
import java.util.List;

class Sports {
    private final String sport;
    private List<String> disciplines = new ArrayList<>();

    /**
     * Constructors for sports with their disciplines
     * @param sport The sport
     * @param discipline The disciplines of the sport
     */
    Sports(String sport, String discipline) {
        this.sport = sport;
        this.disciplines.add(discipline);
    }

    /**
     * Get the sport name
     * @return The sport name
     */
    String getSport() {
        return sport;
    }

    /**
     * Get the list of disciplines of the sport
     * @return The list of disciplines
     */
    List<String> getDisciplines() {
        return disciplines;
    }

    /**
     * Add a discipline to the sport
     * @param discipline The discipline to add
     */
    void addDisciplineToSport(String discipline) {
        disciplines.add(discipline);
    }

    /**
     * Reset the discipline list
     */
    void resetDiscipline() {
        disciplines = new ArrayList<>();
    }
}
