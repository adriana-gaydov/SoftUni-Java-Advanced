package Exam_20February2021;

import java.util.Scanner;

public class Bomb {
    static int sapperRow;
    static int sapperCol;
    static int bombsCount = 0;
    static boolean hasEnded = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int fieldSize = Integer.parseInt(sc.nextLine());
        char[][] field;
        String[] commands = sc.nextLine().split(",");

        field = readMatrix(sc, fieldSize);

        for (String command : commands) {
            if (command.equals("up")) {
                moveSapper(field, sapperRow - 1, sapperCol);
            } else if (command.equals("down")) {
                moveSapper(field, sapperRow + 1, sapperCol);
            } else if (command.equals("left")) {
                moveSapper(field, sapperRow, sapperCol - 1);
            } else if (command.equals("right")) {
                moveSapper(field, sapperRow, sapperCol + 1);
            }
            if (hasEnded) {
                break;
            }
        }

        if (hasEnded) {
            if (bombsCount == 0) {
                System.out.println("Congratulations! You found all bombs!");
            } else {
                System.out.printf("END! %d bombs left on the field", bombsCount);
            }
        } else {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", bombsCount, sapperRow, sapperCol);
        }
    }

    private static void moveSapper(char[][] field, int r, int c) {
        if (!checkIndexes(field, r, c)) {
            return;
        }
        if (field[r][c] == 'e') {
            hasEnded = true;
            return;
        } else if (field[r][c] == 'B') {
            System.out.println("You found a bomb!");
            field[r][c] = '+';
            bombsCount--;
            if (bombsCount == 0) {
                hasEnded = true;
            }
        }
        field[sapperRow][sapperCol] = '+';
        sapperRow = r;
        sapperCol = c;
        field[sapperRow][sapperCol] = 's';
    }

    private static boolean checkIndexes(char[][] field, int r, int c) {
        return r >= 0 && r < field.length && c >= 0 && c < field.length;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }

    private static char[][] readMatrix(Scanner sc, int size) {
        char[][] array = new char[size][size];

        for (int i = 0; i < size; i++) {
            String line = sc.nextLine().replaceAll("\\s+", "");
            array[i] = line.toCharArray();
            if (line.contains("s")) {
                sapperRow = i;
                sapperCol = line.indexOf("s");
            }
            if (line.contains("B")) {
                for (char c : line.toCharArray()) {
                    if (c == 'B') {
                        bombsCount++;
                    }
                }
            }
        }
        return array;
    }
}
