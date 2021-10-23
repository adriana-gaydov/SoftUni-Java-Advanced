import java.io.File;

public class GetFolderSize {
    public static void main(String[] args) {
        String path = "C:\\Users\\Adriana\\Desktop\\SoftUni\\Advanced - Java\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";
        File file = new File(path);

        dfs(file);
        System.out.println(count);
    }

    static int count = 0;
    private static void dfs(File file) {
        if (!file.isDirectory()) {
            count += file.length();
            return;
        }

        File[] files = file.listFiles();
        for (File f : files) {
            dfs(f);
        }
    }
}
