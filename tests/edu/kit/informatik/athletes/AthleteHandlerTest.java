package edu.kit.informatik.athletes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AthleteHandlerTest {
    private AthleteHandler handler;

    @Before
    public void setUp() {
        handler = new AthleteHandler();
        handler.addAthlete(1, "name1", "name1", "GER", "winter", "ski");
        handler.addAthlete(3, "name3", "name3", "FRA", "ball", "soccer");
        handler.addAthlete(2, "name2", "name2", "USA", "winter", "bob");
    }

    @After
    public void tearDown() {
        handler = null;
    }

    @Test
    public void addAthlete() {
        String ex = "Error, this athlete already exists.";
        assertEquals("Failed", ex, handler.addAthlete(2, "name2", "name2", "USA", "winter", "bob"));
        assertEquals("Success", "OK", handler.addAthlete(5, "name5", "name5", "POL", "ball", "basketball"));
        assertEquals("Success", ex, handler.addAthlete(5, "name5", "dsa", "RUS", "winter", "basketball"));
    }

    @Test
    public void summaryAthletes() {
        String ex = "0001 name1 name1 0\n0004 name4 name4 0\n0005 name5 name5 0\n0006 name6 name6 0";

        handler.addAthlete(4, "name4", "name4", "USA", "winter", "ski");
        handler.addAthlete(5, "name5", "name5", "RUS", "winter", "ski");
        handler.addAthlete(6, "name6", "name6", "USA", "winter", "ski");

        String out = handler.summaryAthletes("winter", "ski");
        System.out.println("\nList Athletes:\n" + out);
        assertEquals("Sorted", ex, out);
    }
}