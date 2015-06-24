package fr.univ.blois.siad.m2.todolist;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class WebApplicationTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebApplicationTest.class);

    @Test
    public void initialTest() {
        LOGGER.info("Test Application de base");
    }

    @Test
    public void createApplicationClassTest() {
        ToDoListeApplication toDoListeApplication = new ToDoListeApplication();
        Assert.assertNotNull("L'applicatin n'a pas été instancié", toDoListeApplication);
    }

}
