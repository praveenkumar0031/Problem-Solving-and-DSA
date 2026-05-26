class Solution {
    public int totalFruit(int[] fruits) {
        int l=0,r=0,n=fruits.length,res=0;
        Map<Integer,Integer> w=new HashMap<>();
        while(r<n){
            
            w.put(fruits[r],w.getOrDefault(fruits[r],0)+1);
            while(w.size()>=3){
                w.put(fruits[l],w.get(fruits[l])-1);
                if(w.get(fruits[l])==0)
                    w.remove(fruits[l]);
                l++;
            }
            res=Math.max(r-l+1,res);
            r++;
        }
        return res;
    }
}