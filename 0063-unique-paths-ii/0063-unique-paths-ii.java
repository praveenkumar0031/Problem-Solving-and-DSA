class Solution {
    public int uniquePathsWithObstacles(int[][] ogrid) {
        int m=ogrid.length,n=ogrid[0].length;
        int dp[][]=new int[m][n];
        if (ogrid[0][0] == 1) return 0;
        dp[0][0]=1;
        for(int i=1;i<n;i++){
            if(ogrid[0][i]==0 && dp[0][i-1]==1 )
                dp[0][i]=1;
            else
                dp[0][i]=0;
        }
        for(int i=1;i<m;i++){
            if(ogrid[i][0]==0 && dp[i-1][0]==1 )
                dp[i][0]=1;
            else
                dp[i][0]=0;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(ogrid[i][j]==1){
                    dp[i][j]=0;
                }else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        // for(int[]x:dp){
        //     for(int y:x)
        //         System.out.print(y+" ");
        
        //     System.out.println();
        // }

            return dp[m-1][n-1];
    }
}