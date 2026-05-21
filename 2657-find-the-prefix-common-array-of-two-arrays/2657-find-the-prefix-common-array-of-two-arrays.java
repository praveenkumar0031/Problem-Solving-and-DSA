class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n=A.length,m=B.length;
        boolean pair[]=new boolean[n];
        int res[]=new int[n],ct=0;
        
        for(int i=0;i<n;i++){
            if(pair[A[i]-1])
                ct++;
            else
                pair[A[i]-1]=true;
            if(pair[B[i]-1])
                ct++;
            else
                pair[B[i]-1]=true;
            res[i]=ct;
        }
        
        return res;
    }
}