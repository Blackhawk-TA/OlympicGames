package edu.kit.informatik.competition;

import edu.kit.informatik.athletes.AthleteHandler;
import edu.kit.informatik.core.Core;
import edu.kit.informatik.ioc.IocHandler;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CompetitionHandlerTest {
    private CompetitionHandler handler;
    private AthleteHandler athleteHandler;
    private IocHandler iocHandler;

    @Before
    public void setUp() {
        Core.init(true);

        iocHandler = Core.getIocHandler();
        iocHandler.addIOC("001", "GER", "Germany", 1990);
        iocHandler.addIOC("003", "FRA", "France", 1995);
        iocHandler.addIOC("002", "USA", "USA", 1992);

        athleteHandler = Core.getAthleteHandler();
        athleteHandler.addAthlete("0001", "name1", "name1", "Germany", "winter", "ski");
        athleteHandler.addAthlete("0003", "name3", "name3", "France", "ball", "soccer");
        athleteHandler.addAthlete("0002", "name2", "name2", "USA", "winter", "bob");
    }

    @After
    public void tearDown() {
        iocHandler = null;
        athleteHandler = null;
        handler = null;
    }

    @Test
    public void addCompetition() {
        //TODO fix Athlete not found error
        System.out.println(handler.addCompetition("0001", 2015, "Germany", "winter", "ski", 0, 1, 0));
    }

    @Test
    public void getCompetitions() {
    }
}