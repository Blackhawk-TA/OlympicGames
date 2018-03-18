package edu.kit.informatik.competition;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MedalTableHandlerTest {
    private MedalTableHandler handler;

    @Before
    public void setUp() {
        handler = new MedalTableHandler();
    }

    @After
    public void tearDown() {
        handler = null;
    }

    @Test
    public void listMedals() {
    }
}