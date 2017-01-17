import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Decryptor extends FilterOutputStream{

    private char symbol;

    public Decryptor(OutputStream out, char symbol) {
        super(out);
        this.symbol = symbol;
    }

    @Override
    public void write(int b) throws IOException {
        super.write(b - symbol);
    }

}