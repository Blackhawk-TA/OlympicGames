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
        String ex = "Error, this athlete already exists.";
        assertEquals("Failed", ex, handler.addIOC(2, "CTR2", "country2", 1995));
        assertEquals("Success", "OK", handler.addIOC(4, "CTR4", "country4", 2000));
        assertEquals("Failed", ex, handler.addIOC(4, "CTR4", "country4", 2000));
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