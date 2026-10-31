class Solution {
    private static final long MOD = 1_000_000_007L;

    public int uniquePaths(int[][] grid) {
        final int m = grid.length, n = grid[0].length;

        // A path is a sequence of unit moves. An empty cell lets the robot pick right or down; a mirror forces it:
        // arriving moving right -> leaves moving down, arriving moving down -> leaves moving right.
        // So only "how many ways leave this cell heading right / heading down" has to be tracked, one row at a time.
        final int[] down = new int[n];            // down[j]: ways leaving the cell above (i-1, j) heading down   (< MOD)
        long right = 0;                           // ways leaving the cell on the left (i, j-1) heading right     (un-reduced, < n * MOD)

        for (int i = 0; i < m; i++) {
            final int[] row = grid[i];
            right = (i == 0) ? 1 : 0;             // row 0: one way to stand on the start cell
            for (int j = 0; j < n; j++) {
                final long d = down[j];
                final long keep = row[j] - 1;                  // -1 (all ones) for an empty cell, 0 for a mirror
                down[j] = (int) ((right + (d & keep)) % MOD);  // leave heading down : empty -> right + d, mirror -> right
                right = (right & keep) + d;                    // leave heading right: empty -> right + d, mirror -> d
            }
        }
        return (int) (right % MOD);               // goal cell is empty: both outputs equal the number of arrivals
    }
}