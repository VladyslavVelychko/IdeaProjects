import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class MainTest {

    @Test
    public void testMagic() throws Exception {
        List<String> str = Main.magic(Arrays.asList("aa", "aaaaa", "aaf", "lkjlj"));
        for (String s : str){
            if (s.length() < 2){
                Assert.fail();
            }
        }
    }

}