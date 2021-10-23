import java.util.Scanner;

public class TheMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int rows = Integer.parseInt(input.split("\\s+")[0]);
        int cols = Integer.parseInt(input.split("\\s+")[1]);

        char[][] matrix = new char[rows][cols];
        matrix = readMatrix(sc, rows);

        char fillChar = sc.nextLine().charAt(0);
        input = sc.nextLine();
        int startRow = Integer.parseInt(input.split("\\s+")[0]);
        int startCol = Integer.parseInt(input.split("\\s+")[1]);

       fill (matrix, startRow, startCol, fillChar, matrix[startRow][startCol]);
       printMatrix(matrix);
    }

    private static void fill(char[][] matrix, int row, int col, char fillChar, char startChar) {
        if (matrix[row][col] != startChar) {
            return; // recursion current path ends when char at current position is not startChar
        }

        matrix[row][col] = fillChar;

        if (row + 1 < matrix.length) { // up
            fill(matrix, row + 1, col, fillChar, startChar); // recursion
        }

        if (row - 1 >= 0) { // down
            fill(matrix, row - 1, col, fillChar, startChar); // recursion
        }

        if (col + 1 < matrix[row].length) { // left
            fill(matrix, row, col + 1, fillChar, startChar); // recursion
        }

        if (col - 1 >= 0) { // right
            fill(matrix, row, col - 1, fillChar, startChar); // recursion
        }
    }
    private static char[][] readMatrix(Scanner sc, int rows) {
        char[][] matrix = new char[rows][];

        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = sc.nextLine().replace(" ", "").toCharArray();
        }
        return matrix;
    }

    private static void printMatrix(char[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }
}
