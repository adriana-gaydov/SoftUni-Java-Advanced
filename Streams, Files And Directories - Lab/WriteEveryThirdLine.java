import java.io.*;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Adriana\\Desktop\\SoftUni\\Advanced - Java\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        BufferedReader in = new BufferedReader(new FileReader(path));
        PrintWriter out = new PrintWriter(new FileWriter("output5.txt"));

        String line;
        int br = 0;
        while ((line = in.readLine()) != null) {
            if (++br % 3 == 0) {
                out.println(line);
            }
        }
        out.close();

    }
}
