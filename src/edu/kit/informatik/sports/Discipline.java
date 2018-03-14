package edu.kit.informatik.sports;

class Discipline extends Sport {
    private final String sport;
    private final String discipline;

    /**
     * Constructor for the discipline
     * @param sport The kind of sport
     * @param discipline The specific discipline
     */
    Discipline(String sport, String discipline) {
        super(sport);
        this.sport = super.getName();
        this.discipline = discipline;
    }

    /**
     * Get the sport
     * @return The sport
     */
    String getSport() {
        return sport;
    }

    /**
     * Get the discipline
     * @return The discipline
     */
    String getDiscipline() {
        return discipline;
    }
}
