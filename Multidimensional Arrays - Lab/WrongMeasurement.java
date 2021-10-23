import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = Integer.parseInt(sc.nextLine());
        int[][] matrix = readMatrix(rows, sc, " ");
        int[] index = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int valueToReplace = matrix[index[0]][index[1]];
        int[][] newMatrix = new int[rows][];
        for (int i = 0; i < matrix.length; i++) {
            newMatrix[i] = new int[matrix[i].length];
            for (int j = 0; j < matrix[i].length; j++) {
                int current = matrix[i][j];
                if (!isValid(current, valueToReplace)) {
                    int sum = getSum(i, j, matrix, valueToReplace);
                    newMatrix[i][j] = sum;
                } else {
                    newMatrix[i][j] = matrix[i][j];
                }
            }
        }
        printMatrix(newMatrix);
    }

    private static int getSum(int row, int col, int[][] matrix, int valueToReplace) {
        int sum = 0;

        if (isValidIndex(row - 1, col, matrix)) {
            if (isValid(matrix[row - 1][col], valueToReplace)) {
                sum += matrix[row - 1][col];
            }
        }

        if (isValidIndex(row, col - 1, matrix)) {
            if (isValid(matrix[row][col - 1], valueToReplace)) {
                sum += matrix[row][col - 1];
            }
        }
        if (isValidIndex(row, col + 1, matrix)) {
            if (isValid(matrix[row][col + 1], valueToReplace)) {
                sum += matrix[row][col + 1];
            }
        }

        if (isValidIndex(row + 1 , col, matrix)) {
            if (isValid(matrix[row + 1][col], valueToReplace)) {
                sum += matrix[row + 1][col];
            }
        }
        return sum;
    }

    private static boolean isValidIndex(int row, int col, int[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static boolean isValid(int value, int wrongValue) {
        return value != wrongValue;
    }

    private static int[][] readMatrix(int rows, Scanner sc, String s) {
        int[][] matrix = new int[rows][];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(sc.nextLine().split(s))
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
