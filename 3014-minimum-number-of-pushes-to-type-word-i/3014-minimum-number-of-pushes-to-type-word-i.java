class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int bk= n / 8;
        return (bk * (bk + 1) * 4)
                + (n % 8) * (bk + 1);
    }
}