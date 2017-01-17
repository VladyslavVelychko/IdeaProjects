package collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Random;

import static collection.Main.sort;

public class MainTest {
    @Test
    public void sortTest() throws Exception {

        List<String> lines = Main.readFileLineByLine("test.txt");
        sort(lines);

        Random random = new Random();
        for (int i = 0; i < random.nextInt(100) + 5; i++) {
            int number = random.nextInt(lines.size() - 1);
            Assert.assertTrue(lines.get(number).length() <= lines.get(number + 1).length());
        }

    }

}