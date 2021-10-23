package Threeuple;

public class Threeuple<K, V, S> {
    private K firstValue;
    private V secondValue;
    private S thirdValue;

    public Threeuple(K firstValue, V secondValue, S thirdValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
        this.thirdValue = thirdValue;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append(this.firstValue).append( " -> ").append(this.secondValue).append(" -> ").append(this.thirdValue).toString();
    }
}
