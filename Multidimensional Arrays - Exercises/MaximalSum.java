import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int rows = Integer.parseInt(input.split("\\s+")[0]);
        int cols = Integer.parseInt(input.split("\\s+")[1]);
        int[][] matrix = readMatrix(sc, rows);
        int maxSum = Integer.MIN_VALUE;
        int[][] maxMatrix = new int[3][3];

        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                int[][] curMatrix = new int[3][3];
                int curRow = row;
                int curCol = col;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        curMatrix[i][j] = matrix[curRow][curCol++];
                    }
                    curRow++;
                    curCol = col;
                }
                int curSum =  getSum(curMatrix);
                if (curSum > maxSum) {
                    maxSum = curSum;
                    maxMatrix = curMatrix;
                }
            }
        }
        System.out.printf("Sum = %d%n", maxSum);
        printMatrix(maxMatrix);
    }

    private static  int getSum(int[][] matrix) {
        int sum = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                sum += matrix[r][c];
            }
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

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            Arrays.stream(matrix[i]).forEach(e -> System.out.printf("%d ", e));
            System.out.println();
        }
    }
}
