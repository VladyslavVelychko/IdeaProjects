import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.Assert;
import org.junit.Test;


public class SolutionTest {
    @Test
    public void equalsContract() throws Exception {
        EqualsVerifier.forClass(Person.class).suppress(Warning.NONFINAL_FIELDS).usingGetClass().verify();
    }

    @Test
    public void testReflection() throws Exception {
        Person a = new Person("Vlad", "Velychko", 21);
        Assert.assertTrue(a.equals(a));
    }

    @Test
    public void testSymmetry() throws Exception {
        Person a = new Person("Vlad", "Velychko", 21);
        Person b = a;

        Assert.assertTrue(a.equals(b) && b.equals(a));
    }

    @Test
    public void testTransitivity() throws Exception {
        Person a = new Person("Vlad", "Velychko", 21);
        Person b = new Person("Vlad", "Velychko", 21);
        Person c = new Person("Vlad", "Velychko", 21);

        Assert.assertTrue(a.equals(b) && b.equals(c) && c.equals(a));
    }
}