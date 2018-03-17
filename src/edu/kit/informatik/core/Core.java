package edu.kit.informatik.core;

import edu.kit.informatik.admin.AccountSystem;
import edu.kit.informatik.athletes.*;
import edu.kit.informatik.competition.Competition;
import edu.kit.informatik.competition.CompetitionHandler;
import edu.kit.informatik.ioc.*;
import edu.kit.informatik.competition.MedalTableHandler;
import edu.kit.informatik.sports.*;
import edu.kit.informatik.sportsvenue.*;

import java.util.List;

public class Core {
    private static final AccountSystem ACCOUNT_SYSTEM = new AccountSystem();
    private static final AthleteHandler ATHLETE_HANDLER = new AthleteHandler();
    private static final IocHandler IOC_HANDLER = new IocHandler();
    private static final SportHandler SPORT_HANDLER = new SportHandler();
    private static final SportsVenueHandler SPORTS_VENUE_HANDLER = new SportsVenueHandler();
    private static final CompetitionHandler COMPETITION_HANDLER = new CompetitionHandler();
    private static final MedalTableHandler MEDAL_TABLE_HANDLER = new MedalTableHandler();

    /**
     * Get the Account System
     * @return The Account System
     */
    public static AccountSystem getSystem() {
        return ACCOUNT_SYSTEM;
    }

    /**
     * Get the athlete handler
     * @return The athlete handler
     */
    public static AthleteHandler getAthleteHandler() {
        return ATHLETE_HANDLER;
    }

    /**
     * Get the IOC handler
     * @return The IOC handler
     */
    public static IocHandler getIocHandler() {
        return IOC_HANDLER;
    }

    /**
     * Get the sport handler
     * @return The sport handler
     */
    public static SportHandler getSportHandler() {
        return SPORT_HANDLER;
    }

    /**
     * Get the sport venue handler
     * @return The sport venue handler
     */
    public static SportsVenueHandler getVenueHandler() {
        return SPORTS_VENUE_HANDLER;
    }

    /**
     * Get the athlete list
     * @return The athlete list
     */
    public static List<Athlete> getAthleteList() {
        return ATHLETE_HANDLER.getAthletes();
    }

    /**
     * Get the IOC list
     * @return The IOC list
     */
    public static List<Ioc> getIocList() {
        return IOC_HANDLER.getIocList();
    }

    /**
     * Get the disciplines list
     * @return The disciplines list
     */
    public static List<Discipline> getDisciplines() {
        return SPORT_HANDLER.getDisciplines();
    }

    /**
     * Get the sport venues list
     * @return The sport venues list
     */
    public static List<SportsVenue> getSportsVenues() {
        return SPORTS_VENUE_HANDLER.getSportsVenues();
    }

    /**
     * Get a list of all competitions
     * @return The list of competitions
     */
    public static List<Competition> getCompetitions() {
        return COMPETITION_HANDLER.getCompetitions();
    }
}
