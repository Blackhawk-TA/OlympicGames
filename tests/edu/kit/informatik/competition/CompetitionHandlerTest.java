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
        handler = Core.getCompetitionHandler();

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
        String tooManyMedals = "Error, an athlete can only win one medal per discipline.";
        String invalidMedals = "Error, the athlete can't have won the medals you entered.";
        String invalidYear = "Error, the year is invalid, try a 1926-2018.";
        String invalidAthlete = "Error, the athlete does not exist.";
        String invalidInput = "Error, invalid input. Please check your parameters.";

        assertEquals("Success 1", "OK", handler.addCompetition("0001", 2014, "Germany", "winter", "ski", 0, 1, 0));
        assertEquals("Success 2", "OK", handler.addCompetition("0001", 2015, "Germany", "winter", "ski", 0, 0, 0));
        assertEquals("Success 3", "OK", handler.addCompetition("0001", 2016, "Germany", "winter", "ski", 1, 0, 0));
        assertEquals("2 Medals 1 discipline", tooManyMedals, handler.addCompetition("0001", 2015, "Germany", "winter", "ski", 0, 1, 0));

        assertEquals("Invalid Medals", invalidMedals, handler.addCompetition("0001", 2015, "Germany", "winter", "ski", 1, 1, 0));
        assertEquals("Invalid Year 1", invalidYear, handler.addCompetition("0001", 1925, "Germany", "winter", "ski", 0, 0, 0));
        assertEquals("Invalid Year 2", invalidYear, handler.addCompetition("0001", 2019, "Germany", "winter", "ski", 0, 0, 0));

        assertEquals("Invalid Athlete", invalidAthlete, handler.addCompetition("9999", 2018, "Germany", "winter", "ski", 0, 0, 0));
        assertEquals("Invalid Input", invalidInput, handler.addCompetition("0001", 1925, "USA", "winter", "ski", 0, 0, 0));
    }
}