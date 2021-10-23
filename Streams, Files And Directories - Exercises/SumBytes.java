import java.io.*;

public class SumBytes {
    public static void main(String[] args) {
        String path = "C:\\Users\\Adriana\\Desktop\\SoftUni\\Advanced - Java\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try {
            InputStreamReader reader = new InputStreamReader(new FileInputStream(path));
            PrintWriter writer = new PrintWriter(new FileWriter("output2.txt"));

            long bytes = 0;
            int oneByte = reader.read();
            while (oneByte != -1) {
                if (oneByte != 10 && oneByte != 13) {
                    bytes += oneByte;
                }
                oneByte = reader.read();
            }

            writer.println(bytes);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
