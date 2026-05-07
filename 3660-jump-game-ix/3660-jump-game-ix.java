class Solution {
    public int[] maxValue(int[] nums) {
        int n=nums.length;
        int pre[]=new int[n];
        int suf[]=new int[n];
        int ans[]=new int[n];
        pre[0]=nums[0];
        for(int i=1;i<n;i++){
            pre[i]=Math.max(nums[i],pre[i-1]);
        }
        suf[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            suf[i]=Math.min(nums[i],suf[i+1]);
        }
        ans[n-1]=pre[n-1];
        for(int i=n-2;i>=0;i--){
            if(pre[i]>suf[i+1]){
                ans[i]=ans[i+1];
            }else
                ans[i]=pre[i];
        }
        return ans;
    }
}