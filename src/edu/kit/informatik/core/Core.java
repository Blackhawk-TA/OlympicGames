package edu.kit.informatik.core;

import edu.kit.informatik.admin.AccountSystem;
import edu.kit.informatik.athletes.AthleteHandler;
import edu.kit.informatik.ioc.IocHandler;
import edu.kit.informatik.sports.SportHandler;
import edu.kit.informatik.sportsvenue.SportsVenueHandler;

public class Core {
    private final AccountSystem system = new AccountSystem();
    private final IocHandler iocHandler = new IocHandler();
    private final SportHandler sportHandler = new SportHandler();
    private final SportsVenueHandler venueHandler = new SportsVenueHandler();
    private final AthleteHandler athleteHandler = new AthleteHandler();

    /**
     * Get the Account System
     * @return The Account System
     */
    public AccountSystem getSystem() {
        return system;
    }

    /**
     * Get the IOC handler
     * @return The IOC handler
     */
    public IocHandler getIocHandler() {
        return iocHandler;
    }

    /**
     * Get the sport handler
     * @return The sport handler
     */
    public SportHandler getSportHandler() {
        return sportHandler;
    }

    /**
     * Get the sport venue handler
     * @return The sport venue handler
     */
    public SportsVenueHandler getVenueHandler() {
        return venueHandler;
    }

    /**
     * Get the athlete handler
     * @return The athlete handler
     */
    public AthleteHandler getAthleteHandler() {
        return athleteHandler;
    }
}
