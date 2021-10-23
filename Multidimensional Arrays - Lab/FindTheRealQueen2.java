import java.util.Scanner;

import static java.lang.Math.max;
import static java.util.Collections.min;

public class FindTheRealQueen2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] board;
        board = readMatrix(8, sc, " ");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                String current = board[i][j];
                if (current.equals("q") && !getVertical(i, j, board).contains("q") && !getHorizontal(i, j, board).contains("q")
                     && !getDiagonals(i, j, board).contains("q"))  {
                    System.out.printf("%d %d", i, j);
                    return;
                }
            }
        }
    }

    private static String getHorizontal(int row, int col, String[][] matrix) {
        StringBuilder horizontal = new StringBuilder();
        for (int i = 0; i < col; i++) {
            horizontal.append(matrix[row][i]);
        }

        for (int i = col + 1; i < matrix.length; i++) {
            horizontal.append(matrix[row][i]);
        }
        return horizontal.toString();
    }

    private static String getVertical(int row, int col, String[][] matrix) {
        StringBuilder vertical = new StringBuilder();

        for (int i = 0; i < row; i++) {
            vertical.append(matrix[i][col]);
        }

        for (int i = row + 1; i < matrix.length; i++) {
            vertical.append(matrix[i][col]);
        }
        return vertical.toString();
    }

    private static String getDiagonals(int row, int col, String[][] matrix) {
        StringBuilder diagonals = new StringBuilder();

        for (int i = row - 1, j = col + 1; i >= 0 && j < matrix.length; i--, j++) {  //top right
            diagonals.append(matrix[i][j]);
        }

        for (int i = row + 1, j = col - 1; i < matrix.length && j >= 0; i++, j--) { //bottom left
            diagonals.append(matrix[i][j]);
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) { //top left
            diagonals.append(matrix[i][j]);
        }

        for (int i = row + 1, j = col + 1; i < matrix.length && j < matrix.length; i++, j++) { //bottom right
            diagonals.append(matrix[i][j]);
        }
        return  diagonals.toString();
    }
        private static String[][] readMatrix ( int i, Scanner sc, String s){
            String[][] matrix = new String[i][i];

            for (int j = 0; j < matrix.length; j++) {
                matrix[j] = sc.nextLine().split(" ");
            }
            return matrix;
        }

    }

