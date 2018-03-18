package edu.kit.informatik.core;

import edu.kit.informatik.admin.AccountSystem;
import edu.kit.informatik.athletes.AthleteHandler;
import edu.kit.informatik.competition.CompetitionHandler;
import edu.kit.informatik.competition.MedalTableHandler;
import edu.kit.informatik.ioc.IocHandler;
import edu.kit.informatik.sports.SportHandler;
import edu.kit.informatik.sportsvenue.SportsVenueHandler;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoreTest {
    private AccountSystem accountSystem;
    private MedalTableHandler handlerMedals;
    private IocHandler iocHandler;
    private AthleteHandler athleteHandler;
    private SportHandler sportHandler;
    private CompetitionHandler competitionHandler;
    private SportsVenueHandler sportsVenueHandler;

    @Before
    public void setUp() {
        Core.init(true);

        accountSystem = Core.getSystem();
        accountSystem.addAccount("The", "Admin", "admin", "password");

        handlerMedals = Core.getMedalTableHandler();

        sportsVenueHandler = Core.getVenueHandler();
        sportsVenueHandler.addSportsVenue("001", "Germany", "Berlin", "Olympia", 1935, 80000);

        iocHandler = Core.getIocHandler();
        iocHandler.addIOC("001", "GER", "Germany", 1990);

        sportHandler = Core.getSportHandler();
        sportHandler.addDiscipline("winter", "ski");

        athleteHandler = Core.getAthleteHandler();
        athleteHandler.addAthlete("0001", "name1", "name1", "Germany", "winter", "ski");

        competitionHandler = Core.getCompetitionHandler();
        competitionHandler.addCompetition("0003", 2018, "Germany", "winter", "ski", 0, 1, 0);
    }

    @After
    public void tearDown() {
        accountSystem = null;
        handlerMedals = null;
        iocHandler = null;
        athleteHandler = null;
        competitionHandler = null;
        sportsVenueHandler = null;
    }

    @Test
    public void reset() {
        Core.reset();

        assertEquals("Admin", "OK", accountSystem.login("admin", "password"));
        assertEquals("Medals", "Error, no competitions to create a medal table registered yet.", handlerMedals.listMedals());
        assertEquals("SportVenue", "Error, no sport venues registered yet.", sportsVenueHandler.listSportVenues("Germany"));
        assertEquals("Sports", "Error, no sports registered yet.", sportHandler.listSports());
        assertEquals("IOC", "Error, no IOC codes registered yet.", iocHandler.listIOC());
        assertEquals("Athlete", "Error, no athletes registered yet.", athleteHandler.summaryAthletes("winter", "ski"));

        assertTrue("Sports empty", sportHandler.listSports().isEmpty());
        assertTrue("SportVenues empty", sportsVenueHandler.getSportsVenues().isEmpty());
        assertTrue("IOCList empty", iocHandler.getIocList().isEmpty());
        assertTrue("Athletes empty", athleteHandler.getAthletes().isEmpty());
        assertTrue("Competitions empty", competitionHandler.getCompetitions().isEmpty());
    }
}