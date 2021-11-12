package Calculator;

import java.util.ArrayDeque;

public class MrOperation implements Operation {
    ArrayDeque<Integer> memory;

    public MrOperation(ArrayDeque<Integer> memory){
        this.memory = memory;
    }

    @Override
    public void addOperand(int operand) {

    }

    @Override
    public boolean isCompleted() {
        return true;
    }

    @Override
    public int getResult() {
        return this.memory.pop();
    }
}