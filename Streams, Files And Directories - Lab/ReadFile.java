import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("C:\\Users\\Adriana\\Desktop\\SoftUni\\Advanced - Java\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
        PrintStream outputStream = new PrintStream("output1.txt");
        int value = inputStream.read();
        while (value != -1) {
            outputStream.print(Integer.toBinaryString(value) + " ");
            value = inputStream.read();
        }
        outputStream.close();
    }
}
