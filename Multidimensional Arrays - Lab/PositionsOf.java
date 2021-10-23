import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = Integer.parseInt(sc.nextLine().split("\\s+")[0]);
        int[][] matrix = readMatrix(rows, sc, " ");
        int number = Integer.parseInt(sc.nextLine());
        List<int[]> indexes = getPositionsOf(number, matrix);

        if (indexes.isEmpty()) {
            System.out.println("not found");
        } else {
            indexes.forEach(i -> System.out.printf("%d %d%n", i[0], i[1]));
        }
    }

    private static List<int[]> getPositionsOf(int number, int[][] matrix) {
        List<int[]> indexes = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == number) {
                    indexes.add(new int[]{i, j});
                }
            }
        }
        return indexes;
    }

    private static int[][] readMatrix(int rows, Scanner sc, String separator) {
        int[][] matrix = new int[rows][];
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(sc.nextLine().split(separator))
                            .mapToInt(Integer::parseInt)
                            .toArray();
        }
        return matrix;
    }

}
