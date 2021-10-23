package Exam_26June2021;

import java.util.Scanner;

public class Python {
    static int pythonRow;
    static int pythonCol;
    static int pythonLength = 1;
    static int foodCount;
    static boolean hasEnded = false;
    static boolean hasWon = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int matrixSize = Integer.parseInt(sc.nextLine());
        String[] commands = sc.nextLine().split(", ");

        char[][] matrix = readMatrix(sc, matrixSize);

        for (String command : commands) {
            switch (command) {
                case "up":
                    movePython(pythonRow - 1, pythonCol, matrix);
                    break;
                case "down":
                    movePython(pythonRow + 1, pythonCol, matrix);
                    break;
                case "left":
                    movePython(pythonRow, pythonCol - 1, matrix);
                    break;
                case "right":
                    movePython(pythonRow, pythonCol + 1, matrix);
                    break;
            }
            if (hasEnded) {
                System.out.println("You lose! Killed by an enemy!");
                return;
            }
            if (hasWon) {
                System.out.printf("You win! Final python length is %d", pythonLength);
                return;
            }
        }

        System.out.printf("You lose! There is still %d food to be eaten.", foodCount);

    }

    private static void movePython(int row, int col, char[][] matrix) {
        if (!isValidIndex(row, col, matrix)) {
            if (row < 0) {
                row = matrix.length - 1;
            } else if (row >= matrix.length) {
                row = 0;
            }
            if (col < 0) {
                col = matrix.length - 1;
            } else if (col >= matrix.length) {
                col = 0;
            }
        }

        if (matrix[row][col] == 'e') {
            hasEnded = true;
            return;
        }

        if (matrix[row][col] == 'f') {
            foodCount--;
            pythonLength++;
            if (foodCount == 0) {
                hasWon = true;
            }
        }

        matrix[pythonRow][pythonCol] = '*';
        pythonRow = row;
        pythonCol = col;
        matrix[pythonRow][pythonCol] = '*';
    }

    private static char[][] readMatrix(Scanner sc, int matrixSize) {
        char[][] matrix = new char[matrixSize][matrixSize];
        for (int r = 0; r < matrixSize; r++) {
            String line = sc.nextLine().replaceAll("\\s+", "");
            matrix[r] = line.toCharArray();
            if (line.contains("s")) {
                pythonRow = r;
                pythonCol = line.indexOf("s");
            }
            if (line.contains("f")) {
                for (char c : line.toCharArray()) {
                    if (c == 'f') {
                        foodCount++;
                    }
                }
            }
        }
        return matrix;
    }

    private static boolean isValidIndex(int row, int col, char[][] matrix) {
        return row > 0 && row < matrix.length && col > 0 && col < matrix.length;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }
}
