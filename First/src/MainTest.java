import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Test;

public class MainTest extends TestCase {

    @Test
    public void testMagic() throws Exception {
        String [] t = {"aa", "aaaaa", "aaf", "lkjlj"};
        String [] str = Main.magic(t);
        for (String s : str){
            if (s != null && s.length() > 2){
                Assert.fail();
            }
        }
    }

    @Test
    public void testMagic2() throws Exception {
        String [] t = {"aaf", "aaa", "aad", "llj"};

        String [] str = Main.magic(t);

        for (String  st : str) {
            Assert.assertNull(st);
        }

    }
}