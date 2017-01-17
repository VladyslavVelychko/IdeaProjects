import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;

public class CryptographerTest {
    @Test
    public void setRandomKeySymbol() throws Exception {
        String validationString = "abcdefghijklmnopqrstuvwxyz";
        Cryptographer testCr = new Cryptographer("topSecretTest");

        for (int i = 0; i < 1000; i++){
            testCr.setRandomKeySymbol();
            if (!validationString.contains(Character.toString(testCr.getKeySymbol()))){
                Assert.fail();
            }
        }
    }

    @Test
    public void testEncrypt() throws Exception {
        Cryptographer testCr = new Cryptographer("topSecretTest", 'a');

        testCr.encrypt("testData.txt");

        FileInputStream fileInputStream1 = new FileInputStream("topSecretTest.crpt");
        FileInputStream fileInputStream2 = new FileInputStream("testData.txt");

        byte [] buffer1 = new byte[fileInputStream1.available()];
        fileInputStream1.read(buffer1);


        byte [] buffer2 = new byte[fileInputStream2.available()];
        fileInputStream2.read(buffer2);

        for (int i = 0; i < buffer1.length; i++){
            buffer1[i] -= 'a';
        }

        Assert.assertArrayEquals(buffer1, buffer2);
    }

    @Test
    public void testDecrypt() throws Exception {
        Cryptographer testCr = new Cryptographer("topSecretTest");

        testCr.decrypt("testData.txt", "topSecretTest.crpt");

        FileInputStream fileInputStream1 = new FileInputStream("topSecretTest.crpt");
        FileInputStream fileInputStream2 = new FileInputStream("testData.txt");

        byte [] buffer1 = new byte[fileInputStream1.available()];
        fileInputStream1.read(buffer1);


        byte [] buffer2 = new byte[fileInputStream2.available()];
        fileInputStream2.read(buffer2);

        for (int i = 0; i < buffer1.length; i++){
            buffer1[i] -= testCr.getKeySymbol();
        }

        Assert.assertArrayEquals(buffer1, buffer2);
    }

    @Test
    public void testEncAndDecTogether() throws Exception {
        Cryptographer testCr = new Cryptographer("topSecretTest");

        testCr.encrypt("testData.txt");
        testCr.decrypt("testResult.txt");

        FileInputStream fileInputStream1 = new FileInputStream("testData.txt");
        FileInputStream fileInputStream2 = new FileInputStream("testResult.txt");

        byte [] buffer1 = new byte[fileInputStream1.available()];
        fileInputStream1.read(buffer1);

        byte [] buffer2 = new byte[fileInputStream2.available()];
        fileInputStream2.read(buffer2);

        Assert.assertArrayEquals(buffer1, buffer2);
    }

    @Test
    public void testExtension() throws Exception {
        Cryptographer testCr = new Cryptographer("topSecretTest");
        String [] badFileNames = {"slkjf", ".crpt", "slsjf.crpt.txt"};
        String [] goodFileNames = {"crpt.crpt", "a.crpt", "somefile.crpt"};

        for (String  st : badFileNames) {
            Assert.assertFalse(testCr.isContainExtension(st));
        }

        for (String  st : goodFileNames) {
            Assert.assertTrue(testCr.isContainExtension(st));
        }
    }
}