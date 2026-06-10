class Solution {
    void backtrack(int a[],int i,List<List<Integer>> res,boolean vs[],List<Integer> crt){
        if(crt.size()==a.length)
        {
            res.add(new ArrayList<>(crt));
            return;
        }
        if(i>a.length)
            return;
        for(int j=0;j<a.length;j++){
            if(vs[j]||(j>0 && a[j-1]==a[j]&&!vs[j-1]))
                continue;
            vs[j]=true;
            crt.add(a[j]);
            backtrack(a,j+1,res,vs,crt);
            crt.remove(crt.size()-1);
            vs[j]=false;
        }
        return;
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        boolean vs[]=new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums,0,res,vs,new ArrayList<>());
        return res;
    }
}