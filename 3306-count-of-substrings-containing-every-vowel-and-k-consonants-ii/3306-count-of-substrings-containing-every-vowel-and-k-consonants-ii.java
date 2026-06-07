class Solution {
    public long countOfSubstrings(String word, int k) {
        int[][] oc = new int[2][128];
        String vow="aeiou";
        for(char c:vow.toCharArray()){
            oc[0][c]=1;
        }
        long response = 0;
        int currentK = 0, vowels = 0, extraLeft = 0;

        for (int right = 0, left = 0; right < word.length(); right++) {
            char rightChar = word.charAt(right);

            if (oc[0][rightChar] == 1) {
                if (++oc[1][rightChar] == 1) vowels++;
            } else {
                currentK++;
            }

            while (currentK > k) {
                char leftChar = word.charAt(left);
                if (oc[0][leftChar] == 1) {
                    if (--oc[1][leftChar] == 0) vowels--;
                } else {
                    currentK--;
                }
                left++;
                extraLeft = 0;
            }

            while (vowels == 5 && currentK == k && left < right && oc[0][word.charAt(left)] == 1 && oc[1][word.charAt(left)] > 1) {
                extraLeft++;
                oc[1][word.charAt(left)]--;
                left++;
            }

            if (currentK == k && vowels == 5) {
                response += (1 + extraLeft);
            }
        }

        return response;
    }
}