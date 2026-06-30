class Solution {
    public int numberOfSubstrings(String s) {
        int r= 0;
        int[] p={-1, -1, -1};

        for (int i = 0; i < s.length(); i++) {
            p[(s.charAt(i) -'a') ] = i;
            r += Math.min(p[0], Math.min(p[1], p[2])) + 1;
        }

        return r;
    }
}