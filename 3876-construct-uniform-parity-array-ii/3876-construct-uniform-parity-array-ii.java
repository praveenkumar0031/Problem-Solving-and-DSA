class Solution {
    public boolean uniformArray(int[] nums) {
        int max = Integer.MAX_VALUE;

        for (int i : nums) {
            if (i % 2 == 1)
                max= Math.min(max,i);
        }

        
        if (max == Integer.MAX_VALUE)
            return true;

        
        for (int i : nums) {
            if (i% 2 == 0 && i <= max)
                return false;
        }

        return true;
    }
}