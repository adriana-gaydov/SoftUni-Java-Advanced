package Calculator;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayDeque<Integer> memory = new ArrayDeque<>();
        CalculationEngine engine = new CalculationEngine();
        InputInterpreter interpreter = Extensions.buildInterpreter(engine);
        String[] tokens = scanner.nextLine().split("\\s+");
        for (String token : tokens) {
            if(token.equals("end")){
                break;
            }
            interpreter.interpret(token, memory);
        }

        System.out.println(engine.getCurrentResult());
    }
}
