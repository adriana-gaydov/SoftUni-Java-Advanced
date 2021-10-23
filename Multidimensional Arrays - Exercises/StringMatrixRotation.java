import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       // List<List<Character>> matrix = new ArrayList<>();
        String command = sc.nextLine();
        List<String> words = new ArrayList<>();
        int maxLength = 0;

        String input = sc.nextLine();
        while (!input.equals("END")) {
            words.add(input);
            if (words.get(words.size() - 1).length() > maxLength) {
                maxLength = words.get(words.size() - 1).length();
            }
            input = sc.nextLine();
        }

        char[][] matrix = new char[words.size()][maxLength];

        for (int r = 0; r < matrix.length; r++) {
            char[] letters = words.get(r).toCharArray();
            for (int c = 0; c < matrix[r].length; c++) {
                if (c >= words.get(r).length()) {
                    matrix[r][c] = ' ';
                } else {
                    matrix[r][c] = letters[c];
                }
            }
        }

        int degrees = Integer.parseInt(command.split("[()]")[1]) % 360;

       switch (degrees) {
           case 0:
               printMatrix(matrix);
               break;
           case 90:
               printMatrix90(matrix);
               break;
           case 180:
               printMatrix180(matrix);
               break;
           case 270:
               printMatrix270(matrix);
               break;
       }
    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "");
            }
            System.out.println();
        }
    }

    private static void printMatrix90(char[][] matrix) {
        for (int c = 0; c < matrix[0].length; c++) {
            for (int r = matrix.length - 1; r >= 0; r--) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }

    private static void printMatrix180(char[][] matrix) {
        for (int r = matrix.length - 1; r >= 0; r--) {
            for (int c = matrix[r].length - 1; c >= 0; c--) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }

    private static void printMatrix270(char[][] matrix) {
        for (int c = matrix[0].length - 1; c >= 0; c--) {
            for (int r = 0; r < matrix.length; r++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }
}

