import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int rows = Integer.parseInt(input.split("\\s+")[0]);
        int cols = Integer.parseInt(input.split("\\s+")[1]);
        List<List<Integer>> matrix = new ArrayList<>(rows);

        fillMatrix(matrix, rows, cols);
        System.out.println();

        input = sc.nextLine();
        while (!input.equals("Nuke it from orbit")) {
            String[] commands = input.split("\\s+");
            int row = Integer.parseInt(commands[0]);
            int col = Integer.parseInt(commands[1]);
            int radius = Integer.parseInt(commands[2]);

            destroyCells(matrix, row, col, radius);
            matrix.removeIf(List::isEmpty);
            input = sc.nextLine();
        }
        printMatrix(matrix);
    }

    private static void printMatrix(List<List<Integer>> matrix) {
        for (List<Integer> list : matrix) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static void destroyCells(List<List<Integer>> matrix, int row, int col, int radius) {
        for (int r = row - radius; r <= row + radius; r++) {
            if (isInMatrix(r, col, matrix)) {
                matrix.get(r).set(col, 0);
            }
        }

        for (int c = col + radius; c >= col - radius; c--) {
            if (isInMatrix(row, c, matrix)) {
                matrix.get(row).set(c, 0);
            }
        }

        for (List<Integer> list : matrix) {
            list.removeIf(e -> e == 0);
        }
    }

    private static boolean isInMatrix(int row, int col, List<List<Integer>> matrix) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }

    private static void fillMatrix(List<List<Integer>> matrix, int rows, int cols) {
        int num = 1;
        for (int r = 0; r < rows; r++) {
            matrix.add(new ArrayList<>());
            for (int c = 0; c < cols; c++) {
                matrix.get(r).add(num++);
            }
        }
    }
}
