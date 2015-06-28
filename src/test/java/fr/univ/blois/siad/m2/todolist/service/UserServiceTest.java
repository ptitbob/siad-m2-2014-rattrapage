package fr.univ.blois.siad.m2.todolist.service;

import fr.univ.blois.siad.m2.todolist.SIADClassTest;
import fr.univ.blois.siad.m2.todolist.exception.NotFoundEntityException;
import fr.univ.blois.siad.m2.todolist.model.Town;
import fr.univ.blois.siad.m2.todolist.model.User;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by francois on 29/06/15.
 */
public class UserServiceTest extends SIADClassTest {

    private UserService userService;

    @Before
    public void initialize() {
        userService = getNestedInstance(UserService.class);
        userService.clearAll();
    }

    @Test(expected = NotFoundEntityException.class)
    public void testGetUserNotFound() throws Exception {
        userService.getUser(1L);
    }

    @Test
    public void testGetUserList() throws Exception {
        assertEquals(0, userService.getUserList().size());
        userService.createUser(new User("machin"));
        assertEquals(1, userService.getUserList().size());
    }

    @Test
    public void testDeleteUser() throws Exception {
        userService.createUser(new User("machin"));
        assertEquals(1, userService.getUserList().size());
        userService.deleteUser(1L);
        assertEquals(0, userService.getUserList().size());
    }

    @Test
    public void testUpdateUser() throws Exception {
        userService.createUser(new User("machin"));
        assertEquals(new User(1L, "machin"), userService.getUser(1L));
        userService.updateUser(new User(1L, "toto"));
        assertEquals(new User(1L, "toto"), userService.getUser(1L));
    }

    @Test
    public void testCreateUser() throws Exception {
        userService.createUser(new User("machin"));
        assertNotNull(userService.getUser(1L));
        assertEquals(new User(1L, "machin"), userService.getUser(1L));
    }

    @Test
    public void testGetUserByZipCode() throws Exception {
        userService.createUser(new User("toto", new Town("Orléans", "45000")));
        userService.createUser(new User("tata", new Town("Blois", "41000")));
        userService.createUser(new User("titi", new Town("Tours", "37000")));
        assertEquals(3, userService.getUserList().size());
        List<User> userBloisList = userService.getUserByZipCode("41000");
        assertNotNull(userBloisList);
        assertEquals(1, userBloisList.size());
        assertEquals(new User(2L, "tata", new Town("Blois", "41000")), userBloisList.get(0));
    }

}