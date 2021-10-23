import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class AllCapitals {
    public static void main(String[] args) {
        String path = "C:\\Users\\Adriana\\Desktop\\SoftUni\\Advanced - Java\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try {
            List<String> lines = Files.readAllLines(Path.of(path));
            lines.forEach(line -> System.out.println(line.toUpperCase()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
