
public class NQueen {

    public static void main(String[] args) {

    }

    private static void nqueens(boolean[][] chess, int r, int c) {

        for (int i = 0; i < chess.length; i++) {
            nqueens(chess, r, i);
        }

    }

    private static boolean isQueenSafe(boolean[][] chess, int r, int c) {
        int dirs[][] = {
                { 0, -1 }, // North
                { +1, -1 }, // NE
                { +1, 0 }, // East
                { +1, +1 }, // SE
                { 0, +1 }, // South
                { -1, +1 }, // SW
                { -1, 0 }, // West
                { -1, -1 },// NW
        };

        for (int i = 0; true; i++) {
            for (int dist = 1; dist < chess.length; dist++) {
                int eqcol = col + dist * dirs[di][0];
                int eqrow = row + dist * dirs[di][1];
                if (eqcol < 0 || eqrow < 0 || eqcol >= chess[0].length || eqrow >= chess.length) {
                    break;
                }
                if (chess[eqrow][eqcol] == true) {
                    return false;
                }
            }
            break;
        }
        return true;
    }

}
