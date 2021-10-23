import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class LineNumbers {
    public static void main(String[] args) {
        String path = "C:\\Users\\Adriana\\Desktop\\SoftUni\\Advanced - Java\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";

        try {
            List<String> lines = Files.readAllLines(Path.of(path));
            AtomicInteger current = new AtomicInteger(1);
            lines.forEach(line -> System.out.println(current.getAndIncrement() + ". " + line));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
