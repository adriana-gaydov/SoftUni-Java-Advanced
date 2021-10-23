import java.util.Arrays;
import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] board = new String[8][8];
        board = readMatrix(8, sc, " ");
        boolean isRealQueen = false;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                String current = board[i][j];
                if (current.equals("q")) {
                    if (i == 0) {
                        if (j == 0) {
                            isRealQueen = !board[i][j + 1].equals("q") && !board[i + 1][j].equals("q") &&
                                    !board[i + 1][j + 1].equals("q");
                        } else if (j == 7) {
                            isRealQueen = !board[i][j - 1].equals("q") && !board[i + 1][j].equals("q") &&
                                    !board[i + 1][j - 1].equals("q");
                        } else {
                            isRealQueen = !board[i][j + 1].equals("q") && !board[i + 1][j].equals("q") &&
                                    !board[i + 1][j + 1].equals("q") && !board[i][j - 1].equals("q")
                                    &&  !board[i + 1][j - 1].equals("q");
                        }
                    } else if (i == 7) {
                        if (j == 0) {
                            isRealQueen = !board[i][j + 1].equals("q")  && !board[i - 1][j].equals("q")
                                    &&  !board[i - 1][j + 1].equals("q");
                        } else if (j == 7) {
                            isRealQueen = !board[i][j - 1].equals("q")  && !board[i - 1][j].equals("q")
                                    &&  !board[i - 1][j - 1].equals("q");
                        } else {
                            isRealQueen = !board[i][j + 1].equals("q")  && !board[i - 1][j].equals("q")
                                    &&  !board[i - 1][j + 1].equals("q") && !board[i - 1][j - 1].equals("q")
                                    &&  !board[i][j - 1].equals("q");
                        }
                    } else if (j == 0) {
                        isRealQueen = !board[i][j + 1].equals("q") && !board[i + 1][j].equals("q") &&
                                !board[i + 1][j + 1].equals("q");
                    } else if (j == 7) {
                        isRealQueen = !board[i][j - 1].equals("q") && !board[i + 1][j].equals("q") &&
                                !board[i + 1][j - 1].equals("q");
                    }
                    else {
                        isRealQueen =  !board[i][j + 1].equals("q")  && !board[i][j - 1].equals("q") &&
                                !board[i - 1][j - 1].equals("q") &&  !board[i - 1][j].equals("q") &&
                                !board[i - 1][j + 1].equals("q") &&
                                !board[i + 1][j - 1].equals("q") &&  !board[i + 1][j].equals("q") &&
                                !board[i + 1][j + 1].equals("q");

                    }
                }
                if (isRealQueen) {
                    System.out.printf("%d %d", i, j);
                    return;
                }
            }

                }
            }


    private static boolean isRealQueen(String current, String[][] board) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                String t = board[i][j];
            }
        }
        return false;
    }

    private static String[][] readMatrix(int i, Scanner sc, String s) {
        String[][] matrix = new String[i][i];

        for (int j = 0; j < matrix.length; j++) {
            matrix[j] = sc.nextLine().split(" ");
        }
        return matrix;
    }
}
