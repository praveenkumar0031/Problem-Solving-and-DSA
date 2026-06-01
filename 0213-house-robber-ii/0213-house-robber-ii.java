class Solution {
    int getPos(int a[],int st,int ed){
        int prev=0,max=0;
        for(int i=st;i<=ed;i++){
            int t=Math.max(prev+a[i],max);
            prev=max;
            max=t;
        }
        return max;
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1)
            return nums[0];
        return Math.max(getPos(nums,0,n-2),getPos(nums,1,n-1));
    }
}