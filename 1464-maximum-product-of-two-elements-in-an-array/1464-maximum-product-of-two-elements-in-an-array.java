class Solution {
    public int maxProduct(int[] nums) {
        int max=-1,secmax=-1;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]>max){
                secmax=max;
                max=nums[i];
            }else if(nums[i]>secmax){
                secmax=nums[i];
            }
        }
        return (max-1)*(secmax-1);
    }
}