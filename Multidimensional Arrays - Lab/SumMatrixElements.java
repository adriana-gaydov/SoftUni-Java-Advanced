import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(", ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);


        int[][] matrix = readMatrix(rows, sc, ", ");
        int sum = getSumOfMatrix(matrix);

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }

    private static int getSumOfMatrix(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    private static int[][] readMatrix(int rows, Scanner sc, String separator) {
        int[][] matrix = new int[rows][];

        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = Arrays.stream(sc.nextLine().split(separator))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        }
        return matrix;
    }
}
