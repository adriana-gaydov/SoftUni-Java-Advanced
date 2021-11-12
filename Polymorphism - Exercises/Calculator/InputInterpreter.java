package Calculator;

import java.util.ArrayDeque;

public class InputInterpreter {
    private CalculationEngine engine;

    public InputInterpreter(CalculationEngine engine){
        this.engine = engine;
    }

    public boolean interpret(String input, ArrayDeque<Integer> memory) {
        try {
            engine.pushNumber(Integer.parseInt(input));
        }catch (Exception ex){
            engine.pushOperation(this.getOperation(input, memory));
        }
        return true;
    }
    public Operation getOperation(String operation, ArrayDeque<Integer> memory) {
        if (operation.equals("*")) {
            return new MultiplicationOperation();
        }
        if (operation.equals("/")) {
            return new DivisionOperation();
        }
        if (operation.equals("ms")) {
            return new MsOperation(memory);
        }
        if (operation.equals("mr")) {
            return new MrOperation(memory);
        }

        return null;
    }
}
