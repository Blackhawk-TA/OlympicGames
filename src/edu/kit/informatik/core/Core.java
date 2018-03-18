package edu.kit.informatik.core;

import edu.kit.informatik.admin.AccountSystem;
import edu.kit.informatik.athletes.*;
import edu.kit.informatik.competition.CompetitionHandler;
import edu.kit.informatik.ioc.*;
import edu.kit.informatik.competition.MedalTableHandler;
import edu.kit.informatik.sports.*;
import edu.kit.informatik.sportsvenue.*;

public class Core {
    private static AccountSystem accountSystem = new AccountSystem();
    private static AthleteHandler athleteHandler = new AthleteHandler();
    private static IocHandler iocHandler = new IocHandler();
    private static SportHandler sportHandler = new SportHandler();
    private static SportsVenueHandler sportsVenueHandler = new SportsVenueHandler();
    private static CompetitionHandler competitionHandler = new CompetitionHandler();
    private static MedalTableHandler medalTableHandler = new MedalTableHandler();

    /**
     * Resets the data in the system except admin accounts
     */
    public static void reset() {
        athleteHandler = null;
        iocHandler = null;
        sportHandler = null;
        sportsVenueHandler = null;
        competitionHandler = null;
        medalTableHandler = null;

        athleteHandler = new AthleteHandler();
        iocHandler = new IocHandler();
        sportHandler = new SportHandler();
        sportsVenueHandler = new SportsVenueHandler();
        competitionHandler = new CompetitionHandler();
        medalTableHandler = new MedalTableHandler();
    }

    /**
     * Get the Account System
     * @return The Account System
     */
    public static AccountSystem getSystem() {
        return accountSystem;
    }

    /**
     * Get the athlete handler
     * @return The athlete handler
     */
    public static AthleteHandler getAthleteHandler() {
        return athleteHandler;
    }

    /**
     * Get the IOC handler
     * @return The IOC handler
     */
    public static IocHandler getIocHandler() {
        return iocHandler;
    }

    /**
     * Get the sport handler
     * @return The sport handler
     */
    public static SportHandler getSportHandler() {
        return sportHandler;
    }

    /**
     * Get the sport venue handler
     * @return The sport venue handler
     */
    public static SportsVenueHandler getVenueHandler() {
        return sportsVenueHandler;
    }

    /**
     * Get the competition handler
     * @return The competition handler
     */
    public static CompetitionHandler getCompetitionHandler() {
        return competitionHandler;
    }

    /**
     * Get the medal table handle
     * @return The medal table handler
     */
    public static MedalTableHandler getMedalTableHandler() {
        return medalTableHandler;
    }
}
