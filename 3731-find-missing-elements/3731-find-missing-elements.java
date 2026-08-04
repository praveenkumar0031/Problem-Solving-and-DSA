class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min=nums[0],max=min;
        boolean vst[]=new boolean[101];
        for(int i:nums){
            vst[i]=true;
            min=Math.min(min,i);
            max=Math.max(max,i);
        }
        List<Integer> res=new ArrayList<>();
        for(int i=min;i<=max;i++)
            if(!vst[i])
                res.add(i);
        return res;
    }
}