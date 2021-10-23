package Exam_23October2021;

import java.util.Scanner;

public class MouseAndCheese {
    static int mouseRow;
    static int mouseCol;
    static int eatenCheese;
    static boolean hasEnded = false;
    static boolean hasBonusMove = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int matrixSize = Integer.parseInt(sc.nextLine());


        char[][] matrix = readMatrix(sc, matrixSize);
        String command = sc.nextLine();
        while (!command.equals("end")) {
            switch (command) {
                case "up":
                    moveMouse(mouseRow - 1, mouseCol, matrix);
                    if (hasBonusMove) {
                        moveMouse(mouseRow - 1, mouseCol, matrix);
                        hasBonusMove = false;
                    }
                    break;
                case "down":
                    moveMouse(mouseRow + 1, mouseCol, matrix);
                    if (hasBonusMove) {
                        moveMouse(mouseRow + 1, mouseCol, matrix);
                        hasBonusMove = false;
                    }
                    break;
                case "left":
                    moveMouse(mouseRow, mouseCol - 1, matrix);
                    if (hasBonusMove) {
                        moveMouse(mouseRow, mouseCol - 1, matrix);
                        hasBonusMove = false;
                    }
                    break;
                case "right":
                    moveMouse(mouseRow, mouseCol + 1, matrix);
                    if (hasBonusMove) {
                        moveMouse(mouseRow, mouseCol + 1, matrix);
                        hasBonusMove = false;
                    }
                    break;
            }
            if (hasEnded) {
                break;
            }
            command = sc.nextLine();
        }

        if (hasEnded) {
            System.out.println("Where is the mouse?");
        }

        if (eatenCheese < 5) {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - eatenCheese);
        } else {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", eatenCheese);
        }
        printMatrix(matrix);
    }

    public static void moveMouse(int row, int col, char[][] matrix) {
        if (!isValidIndex(row, col, matrix)) {
            matrix[mouseRow][mouseCol] = '-';
            hasEnded = true;
            return;
        }

        if (matrix[row][col] == 'c') {
            eatenCheese++;
        } else if (matrix[row][col] == 'B') {
            hasBonusMove = true;
        }

        matrix[mouseRow][mouseCol] = '-';
        mouseRow = row;
        mouseCol = col;
        matrix[mouseRow][mouseCol] = 'M';
    }

    private static char[][] readMatrix(Scanner sc, int matrixSize) {
        char[][] matrix = new char[matrixSize][matrixSize];
        for (int r = 0; r < matrixSize; r++) {
            String line = sc.nextLine();
            matrix[r] = line.toCharArray();
            if (line.contains("M")) {
                mouseRow = r;
                mouseCol = line.indexOf("M");
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

    private static boolean isValidIndex(int row, int col, char[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix.length;
    }

}
