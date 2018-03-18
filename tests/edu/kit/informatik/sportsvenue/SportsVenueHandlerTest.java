package edu.kit.informatik.sportsvenue;

import edu.kit.informatik.core.Core;
import edu.kit.informatik.ioc.IocHandler;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SportsVenueHandlerTest {
    private SportsVenueHandler handler;
    private IocHandler iocHandler;

    @Before
    public void setUp() {
        Core.init(true);

        iocHandler = Core.getIocHandler();
        iocHandler.addIOC("001", "CTR1", "country1", 1990);
        iocHandler.addIOC("002", "CTR2", "country2", 1995);
        iocHandler.addIOC("003", "CTR3", "country3", 1985);

        handler = Core.getVenueHandler();
        handler.addSportsVenue("001", "country1", "loc1", "name1", 1997, 2000);
        handler.addSportsVenue("004", "country1", "loc4", "name4", 1999, 500);
        handler.addSportsVenue("005", "country1", "loc5", "name5", 1993, 500);
        handler.addSportsVenue("003", "country3", "loc3", "name3", 1502, 1500);
        handler.addSportsVenue("002", "country2", "loc2", "name2", 2010, 1000);
    }

    @After
    public void tearDown() {
        handler = null;
        iocHandler = null;
    }

    @Test
    public void addSportsVenue() {
        String ex1 = "Error, this sports venue already exists.";
        String ex2 = "Error, IOC does not exist.";
        assertEquals("Failed 1", ex1, handler.addSportsVenue("002", "country2", "loc2", "name2", 2010, 1000));
        assertEquals("Success", "OK", handler.addSportsVenue("006", "country2", "loc6", "name6", 2010, 1200));
        assertEquals("Failed 2", ex2, handler.addSportsVenue("077", "country99", "loc7", "name7", 2011, 1400));
    }

    @Test
    public void listSportVenues() {
        String ex = "(1 004 loc4 500)\n(2 005 loc5 500)\n(3 001 loc1 2000)";
        String out = handler.listSportVenues("country1");
        handler.addSportsVenue("002", "country2", "loc2", "name2", 2010, 1000);
        handler.addSportsVenue("001", "country1", "loc9", "name9", 2001, 2000);
        handler.addSportsVenue("004", "country1", "loc8", "name8", 1993, 2500);

        System.out.println("\nSorted Sport Venues:\n" + out);
        assertEquals("Sorted", ex, out);
    }

    @Test
    public void listSportVenuesEmpty() {
        assertEquals("Empty", "Error, no sport venues registered yet.", handler.listSportVenues(""));
    }
}