import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MaximumSumOf2x2SubMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tokens = sc.nextLine().split(", ");
        int rows = Integer.parseInt(tokens[0]);
        int cols = Integer.parseInt(tokens[1]);
        int maxSum = Integer.MIN_VALUE;
        int[][] matrix = readMatrix(rows, sc, ", ");
        int[][] maxMatrix = new int[0][];
        for (int r = 0; r < matrix.length - 1; r++) {
            for (int c = 0; c < matrix[r].length - 1; c++) {
                int current = matrix[r][c];
                int topRight = matrix[r][c + 1];
                int botLeft = matrix[r + 1][c];
                int botRight = matrix[r + 1][c + 1];
                int currentSum = current + topRight + botRight + botLeft;

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    maxMatrix = new int[][]{{current, topRight}, {botLeft, botRight}};
                }
            }
        }
        printMatrix(maxMatrix);
        System.out.println(maxSum);
    }

    private static int[][] readMatrix(int rows, Scanner sc, String s) {
        int[][] matrix = new int[rows][];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(sc.nextLine().split(", "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            Arrays.stream(matrix[i]).forEach(e -> System.out.printf("%d ", e));
            System.out.println();
        }
    }

}
