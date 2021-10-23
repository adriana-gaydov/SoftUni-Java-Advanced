package Exam_18August2021;

import java.util.Scanner;

public class FormulaOne {
    static int playerRow;
    static int playerCol;
    static boolean hasEnded = false;
    static boolean hasBonusMove = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sizeMatrix = Integer.parseInt(sc.nextLine());
        int commandsCount = Integer.parseInt(sc.nextLine());
        char[][] matrix = readMatrix(sc, sizeMatrix);

        while (commandsCount-- > 0) {
            String command = sc.nextLine();


            switch (command) {
                case "up":
                    movePlayer(playerRow - 1, playerCol, matrix);
                    if (hasBonusMove) {
                        movePlayer(playerRow - 1, playerCol, matrix);
                        hasBonusMove = false;
                    }
                    break;
                case "down":
                    movePlayer(playerRow + 1, playerCol, matrix);
                    if (hasBonusMove) {
                        movePlayer(playerRow + 1, playerCol, matrix);
                        hasBonusMove = false;
                    }
                    break;
                case "left":
                    movePlayer(playerRow, playerCol - 1, matrix);
                    if (hasBonusMove) {
                        movePlayer(playerRow, playerCol - 1, matrix);
                        hasBonusMove = false;
                    }
                    break;
                case "right":
                    movePlayer(playerRow, playerCol + 1, matrix);
                    if (hasBonusMove) {
                        movePlayer(playerRow, playerCol + 1, matrix);
                        hasBonusMove = false;
                    }
                    break;
            }
            if (hasEnded) {
                break;
            }
        }
        if (hasEnded) {
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
        }
        printMatrix(matrix);
    }

    private static void movePlayer(int r, int c, char[][] matrix) {
        if (!isValid(r, c, matrix)) {
            if (r < 0) {
                r = matrix.length - 1;
            }
            if (c < 0) {
                c = matrix.length - 1;
            }
            if (r >= matrix.length) {
                r = 0;
            }
            if (c >= matrix.length) {
                c = 0;
            }
        }
        if (matrix[r][c] == 'T') {
            return;
        }

        if (matrix[r][c] == 'B') {
            hasBonusMove = true;
            matrix[playerRow][playerCol] = '.';
            playerRow = r;
            playerCol = c;
            return;
        }

        if (matrix[r][c] == 'F') {
            hasEnded = true;
        }

        if (matrix[playerRow][playerCol] != 'B') {
            matrix[playerRow][playerCol] = '.';
        }
        matrix[r][c] = 'P';
        playerRow = r;
        playerCol = c;
    }

    private static boolean isValid(int row, int col, char[][] matrix) {
        return row >= 0 && col >= 0 && row < matrix.length && col < matrix.length;
    }

    private static char[][] readMatrix(Scanner sc, int size) {
        char[][] matrix = new char[size][size];
        for (int r = 0; r < size; r++) {
            String line = sc.nextLine();
            matrix[r] = line.toCharArray();
            if (line.contains("P")) {
                playerRow = r;
                playerCol = line.indexOf("P");
            }
        }
        return matrix;
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
