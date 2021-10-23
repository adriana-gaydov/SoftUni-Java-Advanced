import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = Integer.parseInt(sc.nextLine().split("\\s+")[0]);
        int[][] firstMatrix = readMatrix(rows, sc, " ");

        rows = Integer.parseInt(sc.nextLine().split("\\s+")[0]);
        int[][] secondMatrix = readMatrix(rows, sc, " ");

        if (areEqual(firstMatrix, secondMatrix)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    public static int[][] readMatrix (int rows, Scanner scanner, String separator) {
        int[][] matrix = new int[rows][];

        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(separator))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        }
        return matrix;
    }

    public static boolean areEqual(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }

        for (int row = 0; row < firstMatrix.length; row++) {
            if (firstMatrix[row].length != secondMatrix[row].length) {
                return  false;
            }

            for (int col = 0; col < firstMatrix[row].length; col++) {
                if (firstMatrix[row][col] != secondMatrix[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }

}
