package Exam_20June2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Snake {
    static int snakeRow;
    static int snakeCol;
    static List<int[]> indexesBurrows = new ArrayList<>();
    static boolean hasEnded = false;
    static int foodCount;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int matrixSize = Integer.parseInt(sc.nextLine());
        char[][] matrix = readMatrix(sc, matrixSize);

        while (true) {
            String command = sc.nextLine();
            switch (command) {
                case "up":
                    movePython(snakeRow - 1, snakeCol, matrix);
                    break;
                case "down":
                    movePython(snakeRow + 1, snakeCol, matrix);
                    break;
                case "left":
                    movePython(snakeRow, snakeCol - 1, matrix);
                    break;
                case "right":
                    movePython(snakeRow, snakeCol + 1, matrix);
                    break;
            }
            if (hasEnded) {
                break;
            }
        }

        if (foodCount < 10) {
            System.out.println("Game over!");
        } else {
            System.out.println("You won! You fed the snake.");
        }
        System.out.printf("Food eaten: %d%n", foodCount);
        printMatrix(matrix);
    }

    private static void movePython(int row, int col, char[][] matrix) {

        if (!isValidIndex(row, col, matrix)) {
            hasEnded = true;
            matrix[snakeRow][snakeCol] = '.';
            return;
        }

        if (matrix[row][col] == 'B') {
            int[] indexesOfBurrow = indexesBurrows.stream()
                    .filter(e -> e[0] == row && e[1] == col)
                    .findFirst().get();
            matrix[indexesOfBurrow[0]][indexesOfBurrow[1]] = '.';

            indexesOfBurrow = indexesBurrows.stream()
                    .filter(e -> e[0] != row && e[1] != col)
                    .findFirst().get();

            matrix[snakeRow][snakeCol] = '.';
            snakeRow = indexesOfBurrow[0];
            snakeCol = indexesOfBurrow[1];
            matrix[snakeRow][snakeCol] = 'S';
            return;
        }

        if (matrix[row][col] == '*') {
            foodCount++;
            if (foodCount == 10) {
                hasEnded = true;
            }
        }

        matrix[snakeRow][snakeCol] = '.';
        snakeRow = row;
        snakeCol = col;
        matrix[snakeRow][snakeCol] = 'S';
    }


    private static char[][] readMatrix(Scanner sc, int matrixSize) {
        char[][] matrix = new char[matrixSize][matrixSize];
        for (int r = 0; r < matrixSize; r++) {
            String line = sc.nextLine();
            matrix[r] = line.toCharArray();
            if (line.contains("S")) {
                snakeRow = r;
                snakeCol = line.indexOf("S");
            }
            if (line.contains("B")) {
                for (char c : line.toCharArray()) {
                    if (c == 'B') {
                        indexesBurrows.add(new int[]{r, line.indexOf("B")});
                    }
                }
            }
        }
        return matrix;
    }

    private static boolean isValidIndex(int row, int col, char[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix.length;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }
}
