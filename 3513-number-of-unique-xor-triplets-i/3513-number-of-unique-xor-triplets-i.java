class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;

        if (n <= 2) 
            return n;

        int mask = 0;
        for (int e: nums) {
            mask |= e;
        }

        return mask + 1;
    }
}