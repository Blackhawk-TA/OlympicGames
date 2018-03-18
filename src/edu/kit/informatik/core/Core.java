package edu.kit.informatik.core;

import edu.kit.informatik.admin.AccountSystem;
import edu.kit.informatik.athletes.*;
import edu.kit.informatik.competition.CompetitionHandler;
import edu.kit.informatik.ioc.*;
import edu.kit.informatik.competition.MedalTableHandler;
import edu.kit.informatik.sports.*;
import edu.kit.informatik.sportsvenue.*;

public class Core {
    private static AccountSystem accountSystem;
    private static AthleteHandler athleteHandler;
    private static IocHandler iocHandler;
    private static SportHandler sportHandler;
    private static SportsVenueHandler sportsVenueHandler;
    private static CompetitionHandler competitionHandler;
    private static MedalTableHandler medalTableHandler;

    /**
     * Init the system Core
     * @param init Setting used to check if function is running on init or on reset
     */
    public static void init(boolean init) {
        if (init)
            accountSystem = new AccountSystem();

        athleteHandler = new AthleteHandler();
        iocHandler = new IocHandler();
        sportHandler = new SportHandler();
        sportsVenueHandler = new SportsVenueHandler();
        competitionHandler = new CompetitionHandler();
        medalTableHandler = new MedalTableHandler();
    }

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

        init(false);
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
