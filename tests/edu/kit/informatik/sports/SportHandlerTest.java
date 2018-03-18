package edu.kit.informatik.sports;

import edu.kit.informatik.core.Core;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SportHandlerTest {
    private SportHandler handler;

    @Before
    public void setUp() {
        Core.init(true);

        handler = Core.getSportHandler();
        handler.addDiscipline("ball", "football");
        handler.addDiscipline("ball", "baseball");
        handler.addDiscipline("ball", "soccer");
        handler.addDiscipline("ball", "basketball");
        handler.addDiscipline("winter", "ski");
        handler.addDiscipline("winter", "biathlon");
    }

    @After
    public void tearDown() {
        handler = null;
    }

    @Test
    public void addDiscipline() {
        String ex = "Error, discipline already exists.";
        assertEquals("Failed", ex, handler.addDiscipline("winter", "biathlon"));
        assertEquals("Success", "OK", handler.addDiscipline("winter", "ice hockey"));
        assertEquals("Failed", ex, handler.addDiscipline("winter", "ice hockey"));
    }

    @Test
    public void listSports() {
        String ex = "ball baseball\nball basketball\nball football\nball soccer\nwinter biathlon\nwinter ski";
        String out = handler.listSports();
        System.out.println("\nList sports:\n" + out);
        assertEquals("Sorted", ex, out);
    }
}