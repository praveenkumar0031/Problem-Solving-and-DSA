class Solution {

    public long maxSum(int[] nums, int k) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        long output = -150000000;
        TreeMap<Integer, Integer> candidates = new TreeMap<>(), others = new TreeMap<>();
        Arrays.sort(copy);
        for (int i = 0; i < nums.length; i++) {
            long m = 0;
           
            for (int j = 0; j < nums.length - k; j++)
                others.put(copy[j], others.getOrDefault(copy[j], 0) + 1);
            for (int j = nums.length - k; j < nums.length; j++)
                candidates.put(copy[j], candidates.getOrDefault(copy[j], 0) + 1);
            for (int j = i; j < nums.length; j++) {
                 
                if (!others.isEmpty()) {
                    int key = others.containsKey(nums[j]) ? nums[j] : others.lastKey(), value = others.get(key);
                    candidates.put(key, candidates.getOrDefault(key, 0) + 1);
                    if (value == 1)
                        others.remove(key);
                    else
                        others.put(key, others.get(key) - 1);
                }
                
                m += candidates.lastKey();
                int key = candidates.lastKey(), value = candidates.lastEntry().getValue();
                if (value == 1)
                    candidates.remove(key);
                else
                    candidates.put(key, value - 1);
                output = Math.max(m, output);
            }
            candidates.clear();
            others.clear();
        }
        return output;
    }

}