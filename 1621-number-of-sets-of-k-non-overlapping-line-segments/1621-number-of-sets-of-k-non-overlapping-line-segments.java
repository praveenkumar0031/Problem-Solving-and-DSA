class Solution {
    long[][][] dp;
    long MOD = 1000000007;

    int solve(int idx, int start, int n, int k) {
        if (k == 0)
            return 1;

        if (idx == n)
            return 0;

        if (dp[idx][k][start] != -1)
            return (int) dp[idx][k][start];

        long ans = 0;

        if (start == 1) {
            ans = (ans + solve(idx, 0, n, k - 1)) % MOD;
            ans = (ans + solve(idx + 1, 1, n, k)) % MOD;
        } else {
            ans = (ans + solve(idx + 1, 1, n, k)) % MOD;
            ans = (ans + solve(idx + 1, 0, n, k)) % MOD;
        }

        return (int) (dp[idx][k][start] = ans);
    }

    public int numberOfSets(int n, int k) {
        dp = new long[n + 1][k + 1][2];

        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= k; j++)
                dp[i][j][0] = dp[i][j][1] = -1;

        return solve(0, 0, n, k);
    }
}