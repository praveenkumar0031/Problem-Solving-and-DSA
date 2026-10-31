class Solution {
    public int uniquePaths(int[][] grid) {
        final int MOD = 1_000_000_007;
        int m = grid.length, n = grid[0].length;
        int[] right = new int[n];
        int[] down = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    right[0] = 1;
                    down[0] = 0;
                    continue;
                }
                int fromTop = 0;
                if (i > 0) {
                    fromTop = grid[i - 1][j] == 0
                            ? (right[j] + down[j]) % MOD
                            : right[j];
                }
                int fromLeft = 0;
                if (j > 0) {
                    fromLeft = grid[i][j - 1] == 0
                            ? (right[j - 1] + down[j - 1]) % MOD
                            : down[j - 1];
                }
                down[j] = fromTop;
                right[j] = fromLeft;
            }
        }
        return (right[n - 1] + down[n - 1]) % MOD;
    }
}