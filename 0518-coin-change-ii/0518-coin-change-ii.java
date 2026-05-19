class Solution {
    public int change(int amount, int[] coins) {
        int m=coins.length,n=amount+1;
        // if(amount==0)
        //     return 
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++)
            Arrays.fill(dp[i],0);
        for(int i=0;i<m;i++){
                dp[i][0]=1;
        }
        
        for(int i=0;i<n;i++){
            if(i%coins[0]==0)
                dp[0][i]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(j-coins[i]>=0)
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i]];
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        // for(int i=0;i<m;i++){
        //         for(int j=0;j<n;j++){
        //         System.out.print(dp[i][j]+" ");
        //         }
        //         System.out.println();
        //     }

        return dp[m-1][n-1];
    }
}