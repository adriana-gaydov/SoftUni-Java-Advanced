import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        int[][] matrix = readMatrix(sc, size);
        int sumMainDiagonal = getSumMainDiagonal(matrix);
        int sumSecondaryDiagonal = getSumSecondaryDiagonal(matrix);
        System.out.println(Math.abs(sumMainDiagonal - sumSecondaryDiagonal));
    }

    private static int getSumMainDiagonal(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static int getSumSecondaryDiagonal(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][matrix.length - i - 1];
        }
        return sum;
    }

    private static int[][] readMatrix(Scanner sc, int size) {
        int[][] matrix = new int[size][];
        for (int r = 0; r < size; r++) {
            matrix[r] = Arrays.stream(sc.nextLine().split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        }
        return matrix;
    }
}
