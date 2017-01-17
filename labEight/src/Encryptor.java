import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Encryptor extends FilterInputStream{

    private char symbol;

    protected Encryptor(InputStream in, char symbol) {
        super(in);
        this.symbol = symbol;
    }

    @Override
    public int read() throws IOException {
        return (super.read() + symbol);
    }

}