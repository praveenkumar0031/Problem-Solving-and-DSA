class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l=1,r=Integer.MIN_VALUE;
        for(int i:piles){
            r=Math.max(r,i);
        }
        int ans=r;
        while(l<=r){
            int m=l+(r-l)/2;
            long time=0;
            for(int i:piles){

                time+=Math.ceil((double)i/m);
                if(time>h)
                    break;
            }
            if(time<=h){
                ans=m;
                r=m-1;
            }
            else{
                l=m+1;
            }
        }
        return ans;
    }
}