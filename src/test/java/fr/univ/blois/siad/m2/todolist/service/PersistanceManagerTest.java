package fr.univ.blois.siad.m2.todolist.service;

import fr.univ.blois.siad.m2.todolist.exception.NotFoundEntityException;
import fr.univ.blois.siad.m2.todolist.model.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersistanceManagerTest {

    private PersistanceManager persistanceManager;

    @Before
    public void initialize() {
        this.persistanceManager = new PersistanceManager();
    }

    @Test
    public void testInstance() {
        assertNotNull(persistanceManager);
    }

    @Test
    public void testCRUD() {
        persistanceManager.persistUser(new User("login"));
        assertEquals(1, persistanceManager.getUserList().size());
        try {
            assertEquals(new User(1L, "login"), persistanceManager.getUserById(1L));
            persistanceManager.deleteUserById(1L);
        } catch (NotFoundEntityException e) {
            fail("suppression non fonctionnelle");
        }
        persistanceManager.persistUser(new User("login"));
        try {
            persistanceManager.updateUser(new User(1L, "tata"));
            assertEquals(new User(1L, "tata"), persistanceManager.getUserById(1L));
        } catch (NotFoundEntityException e) {
            fail();
        }
    }

    @Test(expected = NotFoundEntityException.class)
    public void testExpectedException() throws NotFoundEntityException {
        persistanceManager.getUserById(10L);
    }

}