package fr.univ.blois.siad.m2.todolist.ws.rs;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertNotNull;

/**
 * Created by francois on 24/06/15.
 */
public class PingTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(PingTest.class);

    @Test
    public void initialTest() {
        assertNotNull(new Ping());
    }

}