class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        if(n==0)
                return -1;
        int max[]=new int[n];
        int min[]=new int[n];
        max[0]=nums[0];
        for(int i=1;i<n;i++){
            max[i]=Math.max(max[i-1],nums[i]);
            //System.out.print(max[i]+" ");
        }
        min[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            min[i]=Math.min(min[i+1],nums[i]);
            
        }
        for(int i=0;i<n;i++){
            if(max[i]-min[i]<=k)
                return i;
            //System.out.print(min[i]+" ");
        }
        return -1;
    }
}