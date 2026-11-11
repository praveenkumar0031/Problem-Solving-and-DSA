class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long min, max, ans,ans2;
        min = Math.min(need1, need2);
        max = Math.max(need1, need2);
        ans = (long) need1 * cost1 + (long) need2 * cost2;
        ans2=(long)min * costBoth + (long) (need1 - min) * cost1 + (long) (need2 - min) * cost2;
        ans  = Math.min(ans, ans2);
        ans = Math.min(ans, (long) max * costBoth);
        return ans;   
    }
}