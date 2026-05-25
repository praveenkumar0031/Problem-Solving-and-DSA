class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n=s.length();
        boolean dp[]=new boolean[n];
        int can=0;
        dp[0]=true;
        for(int i=1;i<n;i++){
            if(i-minJump>=0 && dp[i-minJump]){
                can++;
            }
            if(i-maxJump-1>=0 &&dp[i-maxJump-1]){
                can--;
            }
            dp[i]=can>0 && s.charAt(i)=='0';
        }
        return dp[n-1];
    }
}