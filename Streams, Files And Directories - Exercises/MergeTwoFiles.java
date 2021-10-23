import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MergeTwoFiles  {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Adriana\\Desktop\\SoftUni\\Advanced - Java\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String path2 = "C:\\Users\\Adriana\\Desktop\\SoftUni\\Advanced - Java\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";

        List<String> lines1 = Files.readAllLines(Path.of(path));
        List<String> lines2 = Files.readAllLines(Path.of(path2));
        PrintWriter writer = new PrintWriter(new FileWriter("output7.txt"));

        lines1.forEach(l -> writer.println(l));
        lines2.forEach(l -> writer.println(l));
        writer.close();

    }
}
