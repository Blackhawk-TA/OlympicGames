package edu.kit.informatik.competition;

import edu.kit.informatik.core.Core;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MedalTableHandlerTest {
    private MedalTableHandler handler;

    @Before
    public void setUp() {
        Core.init(true);

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