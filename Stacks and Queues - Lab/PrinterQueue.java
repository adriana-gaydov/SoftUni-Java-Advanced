import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<String> printerQueue = new ArrayDeque<>();
        String fileNames = sc.nextLine();

        while (!fileNames.equals("print")) {
            if (!fileNames.equals("cancel")) {
                printerQueue.offer(fileNames);
            } else {
                if (printerQueue.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.printf("Canceled %s%n", printerQueue.poll());
                }
            }
            fileNames = sc.nextLine();
        }
        printerQueue.forEach(System.out::println);
    }
}
