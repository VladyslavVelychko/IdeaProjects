package collection;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void sort(List<String> list){
        Collections.sort(list,(o1, o2) -> o1.length() - o2.length());
    }

    public static List<String> readFileLineByLine(String fileName) throws IOException{
        List<String> lines = new ArrayList<>();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

        String line;
        while ((line = fileReader.readLine()) != null){
            lines.add(line);
        }
        fileReader.close();

        return lines;
    }

    public static void writeFile(String fileName, List<String> lines) throws IOException{
        FileWriter fileWriter = new FileWriter(fileName);

        for (String  st : lines) {
            fileWriter.write(st + '\n');
        }
        fileWriter.close();
    }

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String firstFile = reader.readLine();
        String secondFile = reader.readLine();

        List<String> lines = readFileLineByLine(firstFile);
        sort(lines);
        writeFile(secondFile, lines);

        reader.close();
    }
}