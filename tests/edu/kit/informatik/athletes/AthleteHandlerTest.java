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
        handler.addAthlete("0001", "name1", "name1", "GER", "winter", "ski");
        handler.addAthlete("0003", "name3", "name3", "FRA", "ball", "soccer");
        handler.addAthlete("0002", "name2", "name2", "USA", "winter", "bob");
    }

    @After
    public void tearDown() {
        handler = null;
    }

    @Test
    public void addAthlete() {
        String ex = "Error, this athlete already exists.";
        assertEquals("Failed", ex, handler.addAthlete("0002", "name2", "name2", "USA", "winter", "bob"));
        assertEquals("Success", "OK", handler.addAthlete("0005", "name5", "name5", "POL", "ball", "basketball"));
        assertEquals("Success", ex, handler.addAthlete("0005", "adad", "dsa", "RUS", "winter", "basketball"));
    }
}