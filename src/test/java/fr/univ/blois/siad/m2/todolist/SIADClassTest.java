package fr.univ.blois.siad.m2.todolist;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.AfterClass;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import static javax.xml.bind.Marshaller.JAXB_ENCODING;
import static javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT;

/**
 * Classe utilitaire pour les tests
 */
public class SIADClassTest {

    protected Marshaller marshaller;

    protected static Weld weld;

    protected static WeldContainer weldContainer;

    protected void initializeTest(Class<?> classToTest) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(classToTest);
            this.marshaller = jaxbContext.createMarshaller();
            this.marshaller.setProperty(JAXB_ENCODING, "UTF-8");
            this.marshaller.setProperty(JAXB_FORMATTED_OUTPUT, true);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void tearDown() {
        if (weld != null) {
            weld.shutdown();
        }
    }

    protected <C> C getNestedInstance(Class<C> nestedClass) {
        if (weldContainer == null) {
            weld = new Weld();
            weldContainer = weld.initialize();
        }
        return weldContainer.instance().select(nestedClass).get();
    }

}
