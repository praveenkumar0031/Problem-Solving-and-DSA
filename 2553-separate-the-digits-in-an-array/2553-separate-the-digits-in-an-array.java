class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> res=new ArrayList<>();
        for(int n:nums){
            List<Integer> each=new ArrayList<>();
            while(n>0){
                each.add(n%10);
                n/=10;
            }
            for(int i=each.size()-1;i>=0;i--)
                res.add(each.get(i));
        }
        int ans[]=new  int[res.size()],i=0;
        for(int e:res)
            ans[i++]=e;
        return ans;
    }
}