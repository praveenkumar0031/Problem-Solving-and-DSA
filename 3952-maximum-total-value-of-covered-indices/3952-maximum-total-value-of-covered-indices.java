class Solution {
    public long maxTotal(int[] nums, String s) {
        int n=nums.length;
        long dp[]=new long[3];
        dp[0]=0;
        dp[1]=s.charAt(0)=='1'?nums[0]:Long.MIN_VALUE;
        dp[2]=nums[0];
        for(int i=1;i<n;i++){
            long ndp[]=new long[3];
            Arrays.fill(ndp,Long.MIN_VALUE);
            boolean has=(s.charAt(i)=='1');
            long maxprev=Math.max(dp[0],dp[1]);
            if(maxprev!=Long.MIN_VALUE){
                ndp[0]=maxprev;
            }
            if(has){
                
            if(maxprev!=Long.MIN_VALUE){
                ndp[1]=maxprev+nums[i];
            }
            }

            if(maxprev!=Long.MIN_VALUE){
                ndp[2]=maxprev+nums[i];
            }
            if(has && dp[2]!=Long.MIN_VALUE){
                ndp[0]=Math.max(ndp[0],dp[2]);
                ndp[2]=Math.max(ndp[2],dp[2]+nums[i]);
            }
            dp=ndp;
            
        }
        return Math.max(dp[0],dp[1]);
    }
}