package edu.kit.informatik.competition;

import edu.kit.informatik.athletes.Athlete;
import edu.kit.informatik.athletes.AthleteHandler;
import edu.kit.informatik.athletes.AthleteHandlerTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CompetitionHandlerTest {
    private CompetitionHandler handler;
    private AthleteHandler athleteHandler;

    @Before
    public void setUp() {
        handler = new CompetitionHandler();
        athleteHandler = new AthleteHandler();
        athleteHandler.addAthlete(1, "name1", "name1", "GER", "winter", "ski");
        athleteHandler.addAthlete(3, "name3", "name3", "FRA", "ball", "soccer");
        athleteHandler.addAthlete(2, "name2", "name2", "USA", "winter", "bob");
    }

    @After
    public void tearDown() {
        handler = null;
        athleteHandler = null;
    }

    @Test
    public void addCompetition() {

        System.out.println(handler.addCompetition("0001", 2015, "GER", "winter", "ski", 0, 1, 0));
    }

    @Test
    public void getCompetitions() {
    }
}