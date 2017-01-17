import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static String[] magic(String[] vstring) {
        String[] c = new String[vstring.length];  // на вихід
        int Summary = 0, Middle = 0;  // сума і середнє
        for(int i = 0; i < vstring.length; i++) {   // обчислюємо суму
            Summary = Summary + vstring[i].length();
        }
        Middle = Summary / vstring.length; // обчислюємо середнє
        for(int i = 0; i < vstring.length; i++) {
            if(vstring[i].length() < Middle) {
                c[i]=vstring[i];
            }
        }
        return c;
    }

    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine()); // зчитує к-сть строк

        String [] a = new String[n];

        for (int i = 0; i < n; i++){
            a[i] = reader.readLine();
        }

        String[] b = magic(a);  // на вихід

        for (String str : b){
            if (str != null){
                System.out.println(str);
            }
        }
    }
}