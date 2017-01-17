import java.io.IOException;

public class Solution {

    public static Cryptographer cryptographer;

    public static void main(String[] args) throws IOException {

        cryptographer = new Cryptographer("topSecret");
        cryptographer.encrypt("data.txt");
        cryptographer.decrypt("answer.txt");
    }

}