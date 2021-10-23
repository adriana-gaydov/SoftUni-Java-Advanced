import java.util.Arrays;
import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        int size = Integer.parseInt(input.split(", ")[0]);
        char type = input.split(", ")[1].charAt(0);

        int[][] matrix = new int[size][size];

        if (type == 'A') {
            fillTheMatrixA(matrix);
        } else if (type == 'B') {
            fillTheMatrixB(matrix);
        }

        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            Arrays.stream(matrix[i]).forEach(e -> System.out.print(e + " "));
            System.out.println();
        }
    }

    private static void fillTheMatrixA(int[][] matrix) {
        int t = 1;
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = t++;
            }
        }
    }

    private static void fillTheMatrixB(int[][] matrix) {
        int t = 1;
        for (int col = 0; col < matrix.length; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = t++;
                }
            } else {
                for (int row = matrix.length - 1; row >= 0; row --) {
                    matrix[row][col] = t++;
                }
            }

        }
    }
}
