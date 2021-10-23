import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int rows = Integer.parseInt(input.split("\\s+")[0]);
        int cols = Integer.parseInt(input.split("\\s+")[1]);
        String[][] matrix = readMatrix(sc, rows);

        String command = sc.nextLine();
        while (!command.equals("END")) {
            String[] commandArgs = command.split("\\s+");
            if (isValidCommand(commandArgs, matrix)) {
                int row1 = Integer.parseInt(commandArgs[1]);
                int col1 = Integer.parseInt(commandArgs[2]);
                int row2 = Integer.parseInt(commandArgs[3]);
                int col2 = Integer.parseInt(commandArgs[4]);
                String element1 = matrix[row1][col1];
                String element2 = matrix[row2][col2];
                matrix[row1][col1] = element2;
                matrix[row2][col2] = element1;
                printMatrix(matrix);
            } else {
                System.out.println("Invalid input!");
            }
            command = sc.nextLine();
        }
    }

    private static boolean isValidCommand(String[] commandArgs, String[][] matrix) {
        if (!commandArgs[0].equals("swap")) {
            return  false;
        }

        if (commandArgs.length != 5) {
            return false;
        }

        int row1 = Integer.parseInt(commandArgs[1]);
        int col1 = Integer.parseInt(commandArgs[2]);
        int row2 = Integer.parseInt(commandArgs[3]);
        int col2 = Integer.parseInt(commandArgs[4]);

        if (!(isValidIndex(row1, col1, matrix) && isValidIndex(row2, col2, matrix))) {
            return false;
        }
        return true;
    }

    private static boolean isValidIndex(int row, int col, String[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static String[][] readMatrix(Scanner sc, int size) {
        String[][] matrix = new String[size][];
        for (int r = 0; r < size; r++) {
            matrix[r] = sc.nextLine().split("\\s+");
        }
        return matrix;
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(String.join(" ", matrix[i]));
        }
    }
}
