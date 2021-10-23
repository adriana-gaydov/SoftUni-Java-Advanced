import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = Integer.parseInt(sc.nextLine());
        int cols = Integer.parseInt(sc.nextLine());

        char[][] firstMatrix = readMatrix(rows, cols, sc, " ");
        char[][] secondMatrix = readMatrix(rows, cols, sc, " ");
        char[][] intersectionMatrix = getIntersection(firstMatrix, secondMatrix);
        printMatrix(intersectionMatrix);
    }

    private static char[][] getIntersection(char[][] firstMatrix, char[][] secondMatrix) {
        char[][] matrix = new char[firstMatrix.length][];

        for (int r = 0; r < firstMatrix.length; r++) {
            matrix[r] = new char[firstMatrix[r].length];
            for (int c = 0; c < firstMatrix[r].length; c++) {
                char element = firstMatrix[r][c] == secondMatrix[r][c] ? firstMatrix[r][c] : '*';
                matrix[r][c] = element;
            }
        }
        return matrix;
    }

    private static char[][] readMatrix(int rows, int cols, Scanner sc, String s) {
        char[][] matrix = new char[rows][cols];
        for (int r = 0; r < rows; r++) {
            matrix[r] = sc.nextLine().replace(" ", "").toCharArray();
        }
        return matrix;
    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
