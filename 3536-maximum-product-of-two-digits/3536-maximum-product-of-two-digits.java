class Solution {
    public int maxProduct(int n) {
        int m1=0,m2=0;
        while(n>0){
            int rm=n%10;
            if(rm>m1){
                m2=m1;
                m1=rm;
            }else if(rm>m2){
                m2=rm;
            }
            n/=10;
        }
        return m1*m2;
    }
}