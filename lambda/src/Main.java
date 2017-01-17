import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static List<String> magic(List<String> list){

        if (list.isEmpty()) return list;

        int sum = 0;
        for (String  st : list) {
            sum += st.length();
        }

        int avrg = sum / list.size();

        return list.stream().filter(x -> x.length() > avrg).collect(Collectors.toList());
    }

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String > list = new ArrayList<>();

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++){
            list.add(reader.readLine());
        }

        System.out.println(magic(list));
    }
}