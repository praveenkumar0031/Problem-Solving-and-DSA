class Solution {
    public int minimumPushes(String w) {
        int[] fq = new int[26];
        for (char c : w.toCharArray()) 
            fq[c - 'a']++;
        
        Arrays.sort(fq);
        int ans = 0;
        for (int i = 25; i >= 0 && fq[i] > 0; i--) 
            ans += fq[i] * ((25 - i) / 8 + 1);
        
        return ans;
    }
}