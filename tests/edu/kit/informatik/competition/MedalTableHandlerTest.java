package edu.kit.informatik.competition;

import edu.kit.informatik.athletes.AthleteHandler;
import edu.kit.informatik.core.Core;
import edu.kit.informatik.ioc.IocHandler;
import edu.kit.informatik.sports.SportHandler;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MedalTableHandlerTest {
    private MedalTableHandler handler;
    private SportHandler sportHandler;
    private IocHandler iocHandler;
    private AthleteHandler athleteHandler;
    private CompetitionHandler competitionHandler;

    @Before
    public void setUp() {
        Core.init(true);

        handler = Core.getMedalTableHandler();

        sportHandler = Core.getSportHandler();
        sportHandler.addDiscipline("winter", "ski");
        sportHandler.addDiscipline("ball", "soccer");
        sportHandler.addDiscipline("winter", "bob");

        iocHandler = Core.getIocHandler();
        iocHandler.addIOC("001", "GER", "Germany", 1990);
        iocHandler.addIOC("003", "FRA", "France", 1995);
        iocHandler.addIOC("002", "USA", "USA", 1926);

        athleteHandler = Core.getAthleteHandler();
        athleteHandler.addAthlete("0001", "name1", "name1", "Germany", "winter", "ski");
        athleteHandler.addAthlete("0001", "name1", "name1", "Germany", "winter", "bob");
        athleteHandler.addAthlete("0003", "name3", "name3", "France", "ball", "soccer");
        athleteHandler.addAthlete("0002", "name2", "name2", "USA", "winter", "bob");

        competitionHandler = Core.getCompetitionHandler();
        competitionHandler.addCompetition("0003", 2018, "France", "ball", "soccer", 0, 1, 0);
        competitionHandler.addCompetition("0001", 2014, "Germany", "winter", "ski", 1, 0, 0);
        competitionHandler.addCompetition("0001", 2015, "Germany", "winter", "ski", 1, 0, 0);
        competitionHandler.addCompetition("0001", 2016, "Germany", "winter", "ski", 0, 1, 0);
        competitionHandler.addCompetition("0002", 1926, "USA", "winter", "bob", 0, 1, 0);
    }

    @After
    public void tearDown() {
        iocHandler = null;
        athleteHandler = null;
        competitionHandler = null;
        sportHandler = null;
        handler = null;
    }

    @Test
    public void listMedalsSortedByGold() {
        String ex = "(1,001,GER,Germany,2,1,0,3)\n(2,002,USA,USA,0,1,0,1)\n(3,003,FRA,France,0,1,0,1)";
        String out = handler.listMedals();
        System.out.println("\nSorted medals by gold:\n" + out);
        assertEquals("Sorted medals by gold", ex, out);
    }

    @Test
    public void listMedalsSortBySilver() {
        competitionHandler.addCompetition("0002", 2000, "USA", "winter", "bob", 1, 0, 0);
        competitionHandler.addCompetition("0001", 1996, "Germany", "winter", "bob", 1, 0, 0);
        competitionHandler.addCompetition("0003", 2001, "France", "ball", "soccer", 1, 0, 0);
        competitionHandler.addCompetition("0003", 2003, "France", "ball", "soccer", 0, 1, 0);

        String ex = "(1,001,GER,Germany,3,1,0,4)\n(2,003,FRA,France,1,2,0,3)\n(3,002,USA,USA,1,1,0,2)";
        String out = handler.listMedals();
        System.out.println("\nSorted medals by silver:\n" + out);
        assertEquals("Sorted medals by silver", ex, out);
    }

    @Test
    public void listMedalsSortByBronze() {
        competitionHandler.addCompetition("0002", 2000, "USA", "winter", "bob", 1, 0, 0);
        competitionHandler.addCompetition("0003", 2001, "France", "ball", "soccer", 1, 0, 0);
        competitionHandler.addCompetition("0002", 2002, "USA", "winter", "bob", 0, 0, 1);

        String ex = "(1,001,GER,Germany,2,1,0,3)\n(2,002,USA,USA,1,1,1,3)\n(3,003,FRA,France,1,1,0,2)";
        String out = handler.listMedals();
        System.out.println("\nSorted medals by bronze:\n" + out);
        assertEquals("Sorted medals by bronze", ex, out);
    }

    @Test
    public void listMedalsSortByIOC() {
        competitionHandler.addCompetition("0002", 2000, "USA", "winter", "bob", 1, 0, 0);
        competitionHandler.addCompetition("0003", 2001, "France", "ball", "soccer", 1, 0, 0);
        competitionHandler.addCompetition("0002", 2002, "USA", "winter", "bob", 0, 0, 1);
        competitionHandler.addCompetition("0003", 2002, "France", "ball", "soccer", 0, 0, 1);

        String ex = "(1,001,GER,Germany,2,1,0,3)\n(2,002,USA,USA,1,1,1,3)\n(3,003,FRA,France,1,1,1,3)";
        String out = handler.listMedals();
        System.out.println("\nSorted medals by IOC:\n" + out);
        assertEquals("Sorted medals by IOC", ex, out);
    }
}