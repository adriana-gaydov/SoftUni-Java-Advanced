import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

public class WriteToFile {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Adriana\\Desktop\\SoftUni\\Advanced - Java\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        FileInputStream inputStream = new FileInputStream(path);
        FileOutputStream outputStream = new FileOutputStream("output22.txt");
        Set<Character> characterSet = Set.of(',', '.', '!', '?');
        int oneByte = inputStream.read();
        while (oneByte != -1) {
            if (!characterSet.contains((char)oneByte)) {
                outputStream.write((char)oneByte);
            }
            oneByte = inputStream.read();
        }
        outputStream.close();
    }
}
