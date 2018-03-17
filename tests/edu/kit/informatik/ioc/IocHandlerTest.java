package edu.kit.informatik.ioc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IocHandlerTest {
    private IocHandler handler;

    @Before
    public void setUp() {
        handler = new IocHandler();
        handler.addIOC(1, "CTR1", "country1", 1990);
        handler.addIOC(2, "CTR2", "country2", 1995);
        handler.addIOC(3, "CTR3", "country3", 1985);
    }

    @After
    public void tearDown() {
        handler = null;
    }

    @Test
    public void addIOC() {
        String ex = "Error, this IOC already exists.";
        assertEquals("Failed", ex, handler.addIOC(2, "CTR2", "country2", 1995));
        assertEquals("Success", "OK", handler.addIOC(4, "CTR4", "country4", 2000));
        assertEquals("Failed", ex, handler.addIOC(4, "CTR4", "country4", 2000));
    }

    @Test
    public void listIOC() {
        handler.addIOC(9, "CTR9", "country9", 1990);
        handler.addIOC(6, "CTR6", "country6", 1985);
        handler.addIOC(4, "CTR4", "country4", 1985);

        String ex = "1985 003 CTR3 country3\n1985 004 CTR4 country4\n1985 006 CTR6 country6\n" +
                    "1990 001 CTR1 country1\n1990 009 CTR9 country9\n1995 002 CTR2 country2";
        String out = handler.listIOC();
        System.out.println("\nList IOC:\n" + out);
        assertEquals("Sorted", ex, out);
    }

    @Test
    public void getIndex() {
        assertEquals("Failed", -1, handler.getIndex("CTR0"));
        assertEquals("Success", 1, handler.getIndex("CTR2"));
        assertEquals("Success", 2, handler.getIndex("CTR3"));
    }

    @Test
    public void toIOC() {
        assertEquals("Success", "CTR1", handler.toIOC("country1"));
        assertEquals("Failed", "", handler.toIOC("country0"));
    }
}