class Solution {
    public int largestInteger(int[] a, int k) {
        int[] f = new int[51];
        for (int x : a)
            f[x]++;

        int res = -1, n = a.length;
        for (int i = 0; i < n; i++) 
            if (k == n || (f[a[i]] == 1 && (k == 1 || i == 0 || i == n - 1)))
                res = Math.max(res, a[i]);

        return res;
    }
}