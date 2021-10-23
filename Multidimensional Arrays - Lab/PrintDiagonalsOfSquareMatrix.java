import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = Integer.parseInt(sc.nextLine());
        int[][] matrix = readMatrix(rows, sc, " ");
        printMainDiagonal(matrix);
        printSecondDiagonal(matrix);
    }

    private static int[][] readMatrix(int rows, Scanner sc, String s) {
        int[][] matrix = new int[rows][rows];

        for (int r = 0; r < rows; r++) {
            matrix[r] = Arrays.stream(sc.nextLine().split("\\s+"))
                        .mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }

    private static void printMainDiagonal(int[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            System.out.print(matrix[r][r] + " ");
        }
        System.out.println();
    }

    private static void printSecondDiagonal(int[][] matrix) {
        int c = 0;
        for (int r = matrix.length - 1; r >= 0; r--) {
                System.out.print(matrix[r][c++] + " ");
        }
        System.out.println();
    }
}
