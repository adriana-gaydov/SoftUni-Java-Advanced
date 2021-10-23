import java.io.*;
import java.nio.file.Path;
import java.util.Arrays;

public class SumLines {
    public static void main(String[] args) {
        String path = "C:\\Users\\Adriana\\Desktop\\SoftUni\\Advanced - Java\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try {
            BufferedReader bf = new BufferedReader(new FileReader(path));
            PrintWriter writer = new PrintWriter(new FileWriter("output1.txt"));

            String line = bf.readLine();
            while (line != null) {
                int lines = 0;
                for (char c : line.toCharArray()) {
                    lines += c;
                }
                writer.println(lines);
                line = bf.readLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
