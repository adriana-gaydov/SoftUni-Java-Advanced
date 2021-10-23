import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int rows = Integer.parseInt(input.split("\\s+")[0]);
        int cols = Integer.parseInt(input.split("\\s+")[1]);

        String[][] matrix = new String[rows][cols];
        fillMatrix(matrix);
        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            Arrays.stream(matrix[i]).forEach(e -> System.out.print(e + " "));
            System.out.println();
        }
    }

    private static void fillMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            int firstAndLastLetter = row + 97;
            int middleLetterStart = firstAndLastLetter;

            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = (char)firstAndLastLetter + "" +  (char)(middleLetterStart++) + "" + (char)firstAndLastLetter ;
            }
        }
    }


}
