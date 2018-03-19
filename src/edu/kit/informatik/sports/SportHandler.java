package edu.kit.informatik.sports;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SportHandler {
    private List<Sports> sports = new ArrayList<>();

    /**
     * Adds a discipline and sport if one of them doesn't exist yet
     * @param sport The sport which the discipline belongs to
     * @param discipline The specific discipline
     * @return String, OK if successful, else error message
     */
    public String addDiscipline(String sport, String discipline) {
        if (notExisting(sport, discipline) && !sportExisting(sport)) {
            sports.add(new Sports(sport, discipline));
            return "OK";
        } else if (notExisting(sport, discipline) && sportExisting(sport)) {
            for (Sports sportItem: sports) {
                if (sportItem.getSport().equals(sport)) {
                    sportItem.addDisciplineToSport(discipline);
                    return "OK";
                }
            }
            return "Error, could not create discipline.";
        } else {
            return "Error, discipline already exists.";
        }
    }

    /**
     * Creates a list of all sports and disciplines
     * @return The list of sports and disciplines
     */
    public String listSports() {
        Comparator.comparing(Sports::getSport);

        for (Sports sport: sports) {
            sport.getDisciplines().sort(String::compareTo);
        }

        StringBuilder output = new StringBuilder();
        for (Sports sport: sports) {
            for (String discipline: sport.getDisciplines()) {
                output.append(String.format("%s %s\n", sport.getSport(), discipline));
            }
        }

        if (output.length() >= 1)
            output.setLength(output.length() - 1); //Remove last linebreak

        if (output.length() == 0)
            output.append("Error, no sports registered yet.");

        return output.toString();
    }

    private boolean sportExisting(String sport) {
        for (Sports sportItem: sports) {
            if (sportItem.getSport().equals(sport)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check if sport and discipline combination exists
     * @param sport The sport to search for
     * @param discipline The discipline to search for
     * @return True if it the combination exists false if not
     */
    private boolean notExisting(String sport, String discipline) { //TODO test 1 discipline 2 sports
        for (Sports sportItem: sports) {
            if (sportItem.getSport().equals(sport)) {
                for (String disciplineItem : sportItem.getDisciplines()) {
                    if (disciplineItem.equals(discipline)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Reset the list
     */
    public void reset() {
        for (Sports sport: sports) {
            sport.resetDiscipline();
        }
        sports = new ArrayList<>();
    }
}
