class Solution {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        for(int i=0;i<k;i++)
        {
            for(int j=0;j<k;j++)
            {
                if(i == j)
                    continue;
                int ans = 0;
                for(int l=0;l<n;l++)
                {
                    int target = l%2 == 0 ? i : j;
                    int diff= Math.abs((nums[l]%k)-target);
                    ans += Math.min(diff,k-diff);
                }
                res = Math.min(res,ans);
            }
        }
        return res;
    }
}