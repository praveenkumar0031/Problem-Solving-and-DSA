class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[][] hm = new int[n][2];
        for (int i = 0; i < n; i++) 
            hm[i] = new int[]{nums[i], i};
        Arrays.sort(hm, (a, b) -> a[0] - b[0]);

        int[] geti = new int[n];
        for (int i = 0; i < n; i++) 
            geti[hm[i][1]] = i;

        int[][] st = new int[n][18];
        int val = 0;
        for (int i = 0; i < n; i++) {
            if (val < i) 
                val = i;
            while (val + 1 < n &&
                   hm[val+ 1][0] - hm[val][0] <= maxDiff &&
                   hm[val+ 1][0] - hm[i][0] <= maxDiff)
                val++;
            st[i][0] = val;
        }

        for (int j = 1; j < 18; j++)
            for (int i = 0; i < n; i++)
                st[i][j] = st[st[i][j - 1]][j - 1];

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int a = geti[queries[i][0]], b = geti[queries[i][1]];
            if (a > b) { 
                int t = a;
                a = b;
                b = t; 
                }
            if (a == b) { 
                ans[i] = 0; 
                continue; 
                }

            int curr = a, steps = 0;
            for (int j = 17; j >= 0; j--){
                if (st[curr][j] < b) { 
                    curr = st[curr][j]; 
                    steps += (1 << j); 
                    }
            }

            ans[i] = (st[curr][0] >= b) ? steps + 1 : -1;
        }
        return ans;
    }
}