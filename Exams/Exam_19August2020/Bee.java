package Exam_19August2020;

import java.util.Scanner;

public class Bee {
    static int beeRow;
    static int beeCol;
    static int flowersCount;
    static boolean isOutOfBounds = false;
    static boolean isBonusMove = false;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int territorySize = Integer.parseInt(sc.nextLine());

        char[][] territory;
        territory = readMatrix(sc, territorySize);
        String command = sc.nextLine();

        while (!command.equals("End")) {
            switch (command) {
                case "up":
                    moveBee(territory, beeRow - 1, beeCol);
                    if (isBonusMove) {
                        moveBee(territory, beeRow - 1, beeCol);
                        isBonusMove = false;
                    }
                    break;
                case "down":
                    moveBee(territory, beeRow + 1, beeCol);
                    if (isBonusMove) {
                        moveBee(territory, beeRow + 1, beeCol);
                        isBonusMove = false;
                    }
                    break;
                case "left":
                    moveBee(territory, beeRow, beeCol - 1);
                    if (isBonusMove) {
                        moveBee(territory, beeRow, beeCol - 1);
                        isBonusMove = false;
                    }
                    break;
                case "right":
                    moveBee(territory, beeRow, beeCol + 1);
                    if (isBonusMove) {
                        moveBee(territory, beeRow, beeCol + 1);
                        isBonusMove = false;
                    }
                    break;
            }
            if (isOutOfBounds) {
                System.out.println("The bee got lost!");
                printInfo(territory);
                return;
            }
            command =  sc.nextLine();
        }
        printInfo(territory);
    }

    private static void moveBee(char[][] territory, int r, int c) {
        if (!checkIndexes(territory, r, c)) {
            isOutOfBounds = true;
            territory[beeRow][beeCol] = '.';
            return;
        }
        if (territory[r][c] == 'f') {
            flowersCount++;
        } else if (territory[r][c] == 'O') {
            isBonusMove = true;
        }
        territory[beeRow][beeCol] = '.';
        beeRow = r;
        beeCol = c;
        territory[beeRow][beeCol] = 'B';
    }


    private static boolean checkIndexes(char[][] field, int r, int c) {
        return r >= 0 && r < field.length && c >= 0 && c < field.length;
    }

    private static void printInfo(char[][] matrix) {
        if(flowersCount >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", flowersCount);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - flowersCount);
        }
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    private static char[][] readMatrix(Scanner sc, int size) {
        char[][] array = new char[size][size];

        for (int i = 0; i < size; i++) {
            String line = sc.nextLine().replaceAll("\\s+", "");
            array[i] = line.toCharArray();
            if (line.contains("B")) {
                beeRow = i;
                beeCol = line.indexOf("B");
            }
        }
        return array;
    }
}
