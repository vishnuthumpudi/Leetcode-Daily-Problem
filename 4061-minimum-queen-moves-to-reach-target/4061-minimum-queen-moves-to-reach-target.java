class Solution {
    public int minQueenMoves(int[] source, int[] target) {
        int sr = source[0], sc = source[1];
        int tr = target[0], tc = target[1];

        // Already at target
        if (sr == tr && sc == tc) {
            return 0;
        }

        // Same row, same column, or same diagonal -> one move
        if (sr == tr || sc == tc || Math.abs(sr - tr) == Math.abs(sc - tc)) {
            return 1;
        }

        // On an 8x8 board, any other square is reachable in exactly 2 moves
        return 2;
    }
}