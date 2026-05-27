class Solution {
    public int numberOfSpecialChars(String word) {
        int[] loc=new int[26],uoc=new int[26];
        int n=word.length();
        Arrays.fill(loc,-1);
        Arrays.fill(uoc,-1);
        for(int i=0;i<n;i++){
            char c=word.charAt(i);
            if(Character.isLowerCase(c)){
                loc[c-'a']=i;
            }else if(uoc[c-'A']==-1){
                uoc[c-'A']=i;
            }
        }
        int res=0;
        for(int i=0;i<26;i++){
            if(loc[i]!=-1 && uoc[i]!=-1 && loc[i]<uoc[i])
                res++;
        }
        return res;

    }
}