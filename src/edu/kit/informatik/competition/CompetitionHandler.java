package edu.kit.informatik.competition;

import edu.kit.informatik.athletes.Athlete;
import edu.kit.informatik.core.Core;

import java.util.ArrayList;
import java.util.List;

public class CompetitionHandler {
    private final List<Competition> competitions = new ArrayList<>();

    /**
     * Add a new competition to an athlete
     * @param id The id of the athlete
     * @param year The year the athlete took part
     * @param country The country of the athlete
     * @param sport The sport the athlete is doing
     * @param discipline The discipline the athlete is taking part in
     * @param gold Represents the amount of gold medals the athlete has won
     * @param silver Represents the amount of silver medals the athlete has won
     * @param bronze Represents the amount of bronze medals the athlete has won
     * @return String, OK if successful else error message
     */
    public String addCompetition(String id, int year, String country, String sport, String discipline,
                                 int gold, int silver, int bronze) {
        if (medalsValid(gold, silver, bronze) && yearValid(year) && isValid(id, country, sport, discipline)) {
            if (winValid(id, discipline, gold, silver, bronze)) {
                addMedal(id, gold, silver, bronze);
                competitions.add(new Competition(id, year, country, sport, discipline, gold, silver, bronze));
                return "OK";
            } else {
                return "Error, an athlete can only win one medal per discipline.";
            }
        } else if (!medalsValid(gold, silver, bronze) && yearValid(year) && isValid(id, country, sport, discipline)) {
            return "Error, the athlete can't have won the medals you entered.";
        } else if (medalsValid(gold, silver, bronze) && !yearValid(year) && isValid(id, country, sport, discipline)) {
            return "Error, the year is invalid, try a 1926-2018.";
        } else if (medalsValid(gold, silver, bronze) && yearValid(year) && !isValid(id, country, sport, discipline)) {
            return "Error, the athlete does not exist.";
        } else {
            return "Error, invalid input. Please check your parameters.";
        }
    }

    /**
     * Get a list of all competitions
     * @return The list of competitions
     */
    public List<Competition> getCompetitions() {
        return competitions;
    }
    
    private void addMedal(String id, int gold, int silver, int bronze) {
        for (Athlete athlete: Core.getAthleteHandler().getAthletes()) {
            if (athlete.getId().equals(id) && gold + silver + bronze == 1) {
                athlete.addMedal();
            }
        }
    }

    //Check if athlete has won only one medal in a discipline
    private boolean winValid(String id, String discipline, int gold, int silver, int bronze) {
        for (Competition competition: competitions) {
            if (competition.getId().equals(id) && competition.getDiscipline().equals(discipline)) {
                //Either no medals won, or no medal was won in this discipline by this athlete so far
                return  (gold == 0 && silver == 0 && bronze == 0)
                        ^ (competition.getGold() == 0 && gold == 1)
                        ^ (competition.getSilver() == 0 && silver == 1)
                        ^ (competition.getBronze() == 0 && bronze == 1);
            }
        }
        return false;
    }

    //Check if athlete is valid
    private boolean isValid(String id, String country, String sport, String discipline) {
        for (Athlete athlete: Core.getAthleteHandler().getAthletes()) {
            if (athlete.getId().equals(id) && athlete.getCountry().equals(country) && athlete.getSport().equals(sport)
                && athlete.getDiscipline().equals(discipline)) {
                return true;
            }
        }
        return false;
    }

    //Check if year is valid
    private boolean yearValid(int year) {
        return year >= 1926 && year <= 2018;
    }

    //Check if medals are valid
    private boolean medalsValid(int gold, int silver, int bronze) {
        return  ((gold == 0 || gold == 1) && (silver == 0 || silver == 1) && (bronze == 0 || bronze == 1))
                && ((gold + silver + bronze == 0) || (gold + silver + bronze == 1));
    }
}
