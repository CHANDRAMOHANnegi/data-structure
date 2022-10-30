import java.util.Scanner;

public class KnightPaths {

    public static void main(String[] args) {

        // Scanner sc = new Scanner(System.in);
        // int chessLength = sc.nextInt();
        // int startRow = sc.nextInt();
        // int startCol = sc.nextInt();

        int chess[][] = new int[5][5];
        printPaths(chess, 1, 1, "", 1);
    }

    public static void printPaths(int chess[][], int r, int c, String path, int count) {
        if (chess.length * chess.length == count) {
            System.out.println(path);
            chess[r][c] = 25;
            displayBoard(chess);
            chess[r][c] = 0;
            return;
        }
        int[][] arr = new int[][] {
                { +2, +1 }, // East
                { -2, -1 }, // West
                { +1, -2 }, // North
                { -1, +2 }, // South
                { +2, -1 }, // NE
                { +1, +2 }, // SE
                { -2, -1 }, // SW
                { -1, -2 }, // NW
        };
        chess[r][c] = count;
        for (int i = 0; i < arr.length; i++) {
            boolean isSafe = isknightSafe(chess, r + arr[i][0], c + arr[i][1]);
            if (isSafe) {
                printPaths(chess, r + arr[i][0], c + arr[i][1], path + r + c + " ", count + 1);
            }
        }
        chess[r][c] = 0;
    }

    public static boolean isknightSafe(int chess[][], int r, int c) {
        if (r < chess.length && c < chess[0].length && r >= 0 && c >= 0 && chess[r][c] == 0) {
            return true;
        }
        return false;
    }

    public static void displayBoard(int[][] chess) {
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess.length; j++) {
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
