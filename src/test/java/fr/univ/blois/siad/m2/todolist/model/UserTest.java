package fr.univ.blois.siad.m2.todolist.model;

import fr.univ.blois.siad.m2.todolist.SIADClassTest;
import org.junit.Before;
import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;

/**
 * Created by francois on 28/06/15.
 */
public class UserTest extends SIADClassTest {

    @Before
    public void initialize() {
        initializeTest(User.class);
    }

    @Test
    public void testInitialization() {
        User user = new User();
        assertNotNull(user);
        user = new User(1L, "login");
        assertEquals(1L, user.getId().longValue());
        assertEquals("login", user.getLogin());
    }

    @Test
    public void testXmlBinding() throws URISyntaxException, IOException {
        User user = new User(1L, "login", new Town("Orléans", "45000"));
        StringWriter stringWriter = new StringWriter();
        try {
            marshaller.marshal(user, stringWriter);
            String userXmlSourceFile = new String(Files.readAllBytes(Paths.get(ClassLoader.getSystemResource("user.xml").toURI())));
            assertEquals("La classe est sérialisé en XML, mais le formalisme n'est pas respecté", userXmlSourceFile, stringWriter.toString());
        } catch (JAXBException e) {
            fail("La classe User n'est pas serialisable sous forme XML");
        }
    }

}