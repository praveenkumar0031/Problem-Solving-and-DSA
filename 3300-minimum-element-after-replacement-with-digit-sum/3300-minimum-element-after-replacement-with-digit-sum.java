class Solution {
    public int minElement(int[] nums) {
        int min=Integer.MAX_VALUE;
        for(int m:nums){
            int r=0;
            while(m>0){
                r+=(m%10);
                m/=10;
            }
            min=Math.min(min,r);
        }
        return min;
    }
}