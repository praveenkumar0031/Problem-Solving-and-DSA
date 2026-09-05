class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        if(n==0)
            return -1;
        int min[]=new int[n];
        min[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            min[i]=Math.min(min[i+1],nums[i]);
        }
        int crtmax=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            crtmax=Math.max(crtmax,nums[i]);
            if(crtmax-min[i]<=k)
                return i;
        }
        return -1;
        
    }
}