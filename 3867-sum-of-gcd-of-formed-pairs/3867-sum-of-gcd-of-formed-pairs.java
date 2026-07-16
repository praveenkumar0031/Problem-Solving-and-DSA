class Solution {
    public long gcdSum(int[] nums) {
        int[] pre = new int[nums.length];
        int max = -1;

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            pre[i] = gcd(max, nums[i]);
        }

        Arrays.sort(pre);

        long sum = 0;
        int i = 0, j = nums.length - 1;

        while (i < j) {
            sum += gcd(pre[i], pre[j]);
            i++;
            j--;
        }

        return sum;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t= b;
            b = a % b;
            a = t;
        }
        return a;
    }
}