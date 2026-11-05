class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int[] b = Arrays.copyOf(arr2, arr2.length + 1);
        b[arr2.length] = Integer.MAX_VALUE; 
        Arrays.sort(b);
        Arrays.sort(arr1);
        int count = 0, j = 0;
        for (int a : arr1) {  
            while (b[j] < a - d) j++;
            if (b[j] > a + d) count++;
        }
        return count;
    }
}