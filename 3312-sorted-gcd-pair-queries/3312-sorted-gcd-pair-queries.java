class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int n = nums.length;
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        long[] freq = new long[max + 1];
        for (int num : nums) {
            freq[num]++;
        }

        long[] exact = new long[max + 1];

        for (int gcd = max; gcd >= 1; gcd--) {
            long cnt = 0;

            for (int times = gcd; times <= max; times += gcd) {
                cnt += freq[times];
            }

            exact[gcd] = cnt * (cnt - 1) / 2;

            for (int times = 2 * gcd; times <= max; times += gcd) {
                exact[gcd] -= exact[times];
            }
        }

        long[] pref = new long[max + 1];
        for (int gcd = 1; gcd <= max; gcd++) {
            pref[gcd] = pref[gcd - 1] + exact[gcd];
        }

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            long q = queries[i];

            int left = 1, right = max;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (pref[mid] > q) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            result[i] = left;
        }

        return result;
    }
}