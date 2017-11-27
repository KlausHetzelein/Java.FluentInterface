package fluentInterfaceTests;

import java.util.Date;

import fluentInterfaceSample.IPerson;
import fluentInterfaceSample.Person;
import junit.framework.TestCase;

@SuppressWarnings("deprecation")
public class personTests extends TestCase
{
    public void testGetName()
    {
        final IPerson person = Person.getsBorn("Hans Muster", null);
        assertEquals("Hans Muster", person.getName());
    }

    public void testGetBirthdate()
    {
        final IPerson person = Person.getsBorn("x", new Date(67, 2, 8));
        assertNotNull(person.getBirthdate());
        assertTrue(person.getBirthdate().toLocaleString().contains("1967"));
    }

    public void testFluentDies()
    {
        final IPerson person = Person.getsBorn("hans mustermann", new Date(56, 0, 2)).dies(new Date(88, 2, 2));

        assertNotNull(person.getBirthdate());
        assertTrue(person.getBirthdate().toLocaleString().contains("56"));
    }

    public void testFluentWholeLife()
    {
        final IPerson person = Person.getsBorn("hans mustermann", new Date(56, 0, 2))
                .getsMarried("first wife", new Date(76, 1, 3)).getsDivorced(new Date(78, 2, 4))
                .getsMarried("second wife", new Date(80, 3, 5)).getsWidowed(new Date(98, 4, 6))
                .dies(new Date(110, 5, 7));
        
        final String sWholeLife = person.getWholeLife();
        System.out.println(sWholeLife);
    }

    public void testFluentWholeLifeWithStayInState()
    {
        final IPerson person = Person.getsBorn("hans mustermann", new Date(56, 0, 2)).stayInState()
                .getsMarried("first wife", new Date(76, 1, 3)).stayInState().getsDivorced(new Date(78, 2, 4))
                .stayInState().getsMarried("second wife", new Date(80, 3, 5)).stayInState()
                .getsWidowed(new Date(98, 4, 6)).stayInState().dies(new Date(110, 5, 7)).stayInState();

        final String sWholeLife = person.getWholeLife();
        System.out.println(sWholeLife);
    }
}
