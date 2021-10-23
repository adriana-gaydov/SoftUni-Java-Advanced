import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<String> browserHistory = new ArrayDeque<>();
        String instruction = sc.nextLine();

        while (!instruction.equals("Home")) {
            if (!instruction.equals("back")) {
                browserHistory.push(instruction);
                System.out.println(browserHistory.peek());
            } else {
                if(browserHistory.size() <= 1) {
                    System.out.println("no previous URLs");
                } else {
                    browserHistory.pop();
                    System.out.println(browserHistory.peek());
                }
            }
            instruction = sc.nextLine();
        }


    }
}
