package edu.kit.informatik.sportsvenue;

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
        iocHandler = new IocHandler();
        iocHandler.addIOC(1, "CTR1", "country1", 1990);
        iocHandler.addIOC(2, "CTR2", "country2", 1995);
        iocHandler.addIOC(3, "CTR3", "country3", 1985);

        handler = new SportsVenueHandler();
        handler.addSportsVenue(1, "country1", "loc1", "name1", 1997, 2000);
        handler.addSportsVenue(4, "country1", "loc4", "name4", 1999, 500);
        handler.addSportsVenue(5, "country1", "loc5", "name5", 1993, 500);
        handler.addSportsVenue(3, "country3", "loc3", "name3", 1502, 1500);
        handler.addSportsVenue(2, "country2", "loc2", "name2", 2010, 1000);
    }

    @After
    public void tearDown() {
        handler = null;
        iocHandler = null;
    }

    @Test
    public void addSportsVenue() {
        String ex1 = "Error, this sports venue already exists.";
        String ex2 = "Error, IOC does not exist";
        assertEquals("Failed", ex1, handler.addSportsVenue(2, "country2", "loc2", "name2", 2010, 1000));
        assertEquals("Success", "OK", handler.addSportsVenue(6, "country2", "loc6", "name6", 2010, 1200));
        assertEquals("Failed", ex2, handler.addSportsVenue(77, "country99", "loc7", "name7", 2011, 1400));
    }

    @Test
    public void listSportVenues() {
        System.out.println(handler.listSportVenues("country1"));
    }
}