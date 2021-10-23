import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<String> browserHistoryBack = new ArrayDeque<>();
        ArrayDeque<String> browserHistoryNext = new ArrayDeque<>();
        String command = sc.nextLine();

        while (!command.equals("Home")) {
            if (command.equals("forward")) {
                if (browserHistoryNext.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    browserHistoryBack.push(browserHistoryNext.pop());
                    System.out.println(browserHistoryBack.peek());
                }
            } else if (command.equals("back ")) {
                if (browserHistoryBack.size() <= 1) {
                    System.out.println("no previous URLs");
                } else {
                    browserHistoryNext.push(browserHistoryBack.pop());
                    System.out.println(browserHistoryBack.peek());
                }
            } else {
                browserHistoryBack.push(command);
                browserHistoryNext.clear();
                System.out.println(command);
            }


            command = sc.nextLine();
        }
    }
}
