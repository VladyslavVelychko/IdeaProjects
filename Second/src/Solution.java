import com.google.gson.Gson;

import java.io.*;

public class Solution{
    public static final String fileName = "Second.json";

    public static void main(String [] args) throws IOException{
        Gson gson = new Gson();
        Person one = new Person("Petya", "Pyatochkin", 23);

        String jsonIn = gson.toJson(one);

        FileWriter fileWriter = new FileWriter(fileName);
        fileWriter.write(jsonIn);
        fileWriter.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        String jsonOut = fileReader.readLine();
        fileReader.close();

        Person newOne = gson.fromJson(jsonOut, Person.class);

        System.out.println(one.equals(newOne));
    }
}