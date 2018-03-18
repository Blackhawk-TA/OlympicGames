package edu.kit.informatik.athletes;

import edu.kit.informatik.competition.CompetitionHandler;
import edu.kit.informatik.core.Core;
import edu.kit.informatik.ioc.IocHandler;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AthleteHandlerTest {
    private AthleteHandler handler;
    private CompetitionHandler compHandler;
    private IocHandler iocHandler;

    @Before
    public void setUp() {
        Core.init(true);

        handler = new AthleteHandler();
        handler.addAthlete("0001", "name1", "name1", "GER", "winter", "ski");
        handler.addAthlete("0003", "name3", "name3", "FRA", "ball", "soccer");
        handler.addAthlete("0002", "name2", "name2", "USA", "winter", "bob");

        iocHandler = new IocHandler();
        iocHandler.addIOC("001", "GER", "GER", 1990);

        compHandler = new CompetitionHandler();
        compHandler.addCompetition("0001", 2015, "GER", "winter", "ski", 0, 1, 0);
    }

    @After
    public void tearDown() {
        handler = null;
        compHandler = null;
        iocHandler = null;
    }

    @Test
    public void addAthlete() {
        String ex = "Error, this athlete already exists.";
        assertEquals("Failed", ex, handler.addAthlete("0002", "name2", "name2", "USA", "winter", "bob"));
        assertEquals("Success", "OK", handler.addAthlete("0005", "name5", "name5", "POL", "ball", "basketball"));
        assertEquals("Success", ex, handler.addAthlete("0005", "name5", "dsa", "RUS", "winter", "basketball"));
    }

    @Test
    public void summaryAthletes() { //TODO test medals
        String ex = "0001 name1 name1 0\n0004 name4 name4 0\n0005 name5 name5 0\n0006 name6 name6 0";

        handler.addAthlete("0004", "name4", "name4", "USA", "winter", "ski");
        handler.addAthlete("0005", "name5", "name5", "RUS", "winter", "ski");
        handler.addAthlete("0006", "name6", "name6", "USA", "winter", "ski");

        String out = handler.summaryAthletes("winter", "ski");
        System.out.println("\nList Athletes:\n" + out);
        assertEquals("Sorted", ex, out);
    }
}