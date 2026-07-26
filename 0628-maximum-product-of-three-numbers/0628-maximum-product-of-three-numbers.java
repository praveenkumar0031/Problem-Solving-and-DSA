class Solution {
    public int maximumProduct(int[] a) {
        Arrays.sort(a);
        int n=a.length;
        return Math.max(a[n-1]*a[n-2]*a[n-3],a[n-1]*a[0]*a[1]);
    }
}