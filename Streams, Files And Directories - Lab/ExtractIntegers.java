import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Adriana\\Desktop\\SoftUni\\Advanced - Java\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        FileInputStream inputStream = new FileInputStream(path);
        Scanner sc = new Scanner(inputStream);
        PrintStream outputStream = new PrintStream("output4.txt");

        while (sc.hasNext()) {
            if (sc.hasNextInt()) {
                outputStream.println(sc.nextInt());
            }
            sc.next();
        }
        outputStream.close();
    }
}
