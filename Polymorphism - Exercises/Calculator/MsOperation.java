package Calculator;

import java.util.ArrayDeque;

public class MsOperation implements Operation {
    private ArrayDeque<Integer> memory;

    public MsOperation(ArrayDeque<Integer> memory) {
        this.memory = memory;
    }

    @Override
    public void addOperand(int operand) {
        memory.push(operand);
    }

    @Override
    public boolean isCompleted() {
        return false;
    }

    @Override
    public int getResult() {
        return -1;
    }


}