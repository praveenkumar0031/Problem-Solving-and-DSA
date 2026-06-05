class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==1)
            return 0;
        
        int n=nums.length,l=0,r=n-1;
        while(l<=r){
            int m=l+(r-l)/2;
            boolean lp=(m==0||nums[m]>nums[m-1]);
            boolean rp=(m==n-1||nums[m]>nums[m+1]);

            if(lp&&rp){
                return m;
            }
            
            if(m<n-1 && nums[m]<nums[m+1]){
                l=m+1;
            }else{
                r=m-1;
            }
        }
        
        return -1;
    }
}