class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n=items.length,val[]=new int[n],min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int fact=items[i][0],crtprice=items[i][1];
            min=Math.min(min,crtprice);
            int ct=0;
            for(int j=0;j<n;j++){
                if(i!=j && items[j][0]%fact==0){
                    ct++;
                }
            }
            val[i]=ct+1;
        }
        if(min>budget){
            return 0;
        }
        int dp[]=new int[budget+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        for(int i=0;i<n;i++){
            int crtprice=items[i][1];
            for(int j=budget;j>=crtprice;j--){
                if(dp[j-crtprice]!=-1){
                    dp[j]=Math.max(dp[j],dp[j-crtprice]+val[i]);
                }
            }
        }
        int res=0;
        for(int i=0;i<=budget;i++){
            if(dp[i]!=-1){
                int crt=dp[i]+(budget-i)/min;
                res=Math.max(res,crt);
            }
        }
        return res;
    }
}