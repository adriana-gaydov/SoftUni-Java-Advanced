import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class SortLines {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Adriana\\Desktop\\SoftUni\\Advanced - Java\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        List<String> lines = Files.readAllLines(Path.of(path));
        Collections.sort(lines);

        PrintWriter out = new PrintWriter("output7.txt");
        for (String line : lines) {
            out.println(line);
        }
        out.close();
    }
}
