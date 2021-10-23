import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class CopyBytes {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Adriana\\Desktop\\SoftUni\\Advanced - Java\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        FileInputStream inputStream = new FileInputStream(path);
        PrintStream outputStream = new PrintStream("output3.txt");

        int oneByte = inputStream.read();
        while (oneByte != -1) {
            if ((char)oneByte != ' ' && (char)oneByte != '\n') {
                outputStream.print(oneByte);
            } else {
                outputStream.print((char)oneByte);
            }
            oneByte = inputStream.read();
        }
    }
}
