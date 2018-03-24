package edu.kit.informatik.athletes;

import edu.kit.informatik.competition.CompetitionHandler;
import edu.kit.informatik.core.Core;
import edu.kit.informatik.ioc.IocHandler;
import edu.kit.informatik.sports.SportHandler;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AthleteHandlerTest {
    private AthleteHandler handler;
    private SportHandler sportHandler;
    private CompetitionHandler compHandler;
    private IocHandler iocHandler;

    @Before
    public void setUp() {
        Core.init(true);

        sportHandler = Core.getSportHandler();
        sportHandler.addDiscipline("winter", "ski");
        sportHandler.addDiscipline("ball", "soccer");
        sportHandler.addDiscipline("ball", "basketball");
        sportHandler.addDiscipline("winter", "basketball");
        sportHandler.addDiscipline("winter", "bob");

        iocHandler = Core.getIocHandler();
        iocHandler.addIOC("001", "GER", "Germany", 1990);
        iocHandler.addIOC("003", "FRA", "France", 1995);
        iocHandler.addIOC("002", "USA", "USA", 1992);

        handler = Core.getAthleteHandler();
        handler.addAthlete("0001", "name1", "name1", "Germany", "winter", "ski");
        handler.addAthlete("0003", "name3", "name3", "France", "ball", "soccer");
        handler.addAthlete("0002", "name2", "name2", "USA", "winter", "bob");

        compHandler = new CompetitionHandler();
        compHandler.addCompetition("0001", 2015, "Germany", "winter", "ski", 1, 0, 0);
        compHandler.addCompetition("0001", 2016, "Germany", "winter", "ski", 0, 1, 0);
        compHandler.addCompetition("0001", 2017, "Germany", "winter", "ski", 0, 1, 0);
    }

    @After
    public void tearDown() {
        compHandler = null;
        iocHandler = null;
        sportHandler = null;
        handler = null;
    }

    @Test
    public void addAthlete() {
        String ex1 = "Error, this athlete already exists.";
        String ex2 = "Error, this country isn't registered in the IOC list.";
        String ex3 = "Error, the athlete already exists with a different name or country.";
        String ex4 = "Error, this sport is not registered yet.";
        assertEquals("Failed 1", ex2, handler.addAthlete("0009", "name2", "name2", "Russia", "winter", "bob"));
        assertEquals("Success", "OK", handler.addAthlete("0005", "name5", "name5", "France", "ball", "basketball"));
        assertEquals("Success", "OK", handler.addAthlete("0005", "name5", "name5", "France", "ball", "soccer"));
        assertEquals("Success", "OK", handler.addAthlete("0006", "name5", "name5", "France", "ball", "basketball"));
        assertEquals("Failed 0", ex4, handler.addAthlete("0006", "name5", "name5", "France", "awd", "awd"));
        assertEquals("Failed 1", ex3, handler.addAthlete("0005", "name5", "name5", "Germany", "winter", "basketball"));
        assertEquals("Failed 2", ex3, handler.addAthlete("0005", "name5", "name6", "France", "winter", "basketball"));
        assertEquals("Failed 3", ex3, handler.addAthlete("0005", "name6", "name5", "France", "winter", "basketball"));
        assertEquals("Success", "OK", handler.addAthlete("0005", "name5", "name5", "France", "winter", "basketball"));
        assertEquals("Failed 4", ex1, handler.addAthlete("0005", "name5", "name5", "France", "winter", "basketball"));
    }

    @Test
    public void summaryAthletes() {
        String ex = "0001 name1 name1 3\n0004 name4 name4 2\n0006 name6 name6 2\n0005 name5 name5 1";

        handler.addAthlete("0004", "name4", "name4", "USA", "winter", "ski");
        handler.addAthlete("0005", "name5", "name5", "Germany", "winter", "ski");
        handler.addAthlete("0006", "name6", "name6", "France", "winter", "ski");

        compHandler.addCompetition("0006", 2015, "France", "winter", "ski", 1, 0, 0);
        compHandler.addCompetition("0006", 2016, "France", "winter", "ski", 0, 1, 0);
        compHandler.addCompetition("0004", 2015, "USA", "winter", "ski", 0, 1, 0);
        compHandler.addCompetition("0004", 2016, "USA", "winter", "ski", 0, 1, 0);
        compHandler.addCompetition("0005", 2016, "Germany", "winter", "ski", 1, 0, 0);

        String out = handler.summaryAthletes("winter", "ski");
        System.out.println("\nList Athletes:\n" + out);
        assertEquals("Sorted", ex, out);

        assertEquals("No list", "", handler.summaryAthletes("test", "test"));
    }
}