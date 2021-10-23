import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;

public class NestedFolders{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("C:\\Users\\Adriana\\Desktop\\SoftUni\\Advanced - Java\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources");
		
		ArrayDeque<File> queue = new ArrayDeque<>();
		queue.offer(file);
		int count = 0;
		
		while (!queue.isEmpty()) {
			File[] files = queue.poll().listFiles();
			
			for (File f: files) {
				if (f.isDirectory()) {
					queue.offer(f);
					System.out.println(f.getName());
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
