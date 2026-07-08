class Solution {
    public int[] sumAndMultiply(String s, int[][] q) {
        int MOD = 1000000007,n = s.length();
        long[] pow10 = new long[n + 1];
        pow10[0] = 1;

        for (int i = 1; i <= n; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        int[] idx = new int[n + 1];
        long[] val = new long[n + 1], total = new long[n + 1];

        int ct = 0;

        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';

            if (d!= 0) {
                ct++;
                val[ct] = (val[ct - 1] * 10 + d) % MOD;
                total[ct] = total[ct - 1] + d;
            }

            idx[i + 1] = ct;
        }

        int[] ans = new int[q.length];

        for (int i = 0; i < q.length; i++) {

            int l = q[i][0];
            int r = q[i][1];

            int left = idx[l];
            int right = idx[r + 1];

            if (left == right) {
                ans[i] = 0;
                continue;
            }

            int len = right - left;
            long number = (val[right] - (val[left] * pow10[len]) % MOD) % MOD;

            if (number < 0)
                number += MOD;

            long sum = total[right] - total[left];
            ans[i] = (int) ((number * sum) % MOD);
        }

        return ans;
    }
}