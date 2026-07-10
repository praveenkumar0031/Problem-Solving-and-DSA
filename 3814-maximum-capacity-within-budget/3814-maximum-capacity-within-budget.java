class Solution {
    public int maxCapacity(int[] costs, int[] capacity, int budget) {
        int n = costs.length;
        int arr[][] = new int[n][2];
        for(int i=0; i<n; i++){
            arr[i][0] = costs[i];
            arr[i][1] = capacity[i];
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int p[] = new int[n];
        p[0] = arr[0][1];
        for(int i=1; i < n; i++){
            p[i] = Math.max(p[i-1], arr[i][1]);
        }
        int max = 0;
        for(int i=0; i<n; i++){
            int cost1 = arr[i][0];
            int cap1 = arr[i][1];
            if(cost1 < budget){
                max = Math.max(max, cap1);
            } else {
                break;
            }
            int target = budget - cost1;
            int l = 0; int r = i-1;
            int idx = -1;
            while(l <= r){
                int mid = (l + r)/2;
                if(arr[mid][0] < target){
                    idx = mid;
                    l = mid+1;
                } else {
                    r = mid - 1;
                }
            }
            if(idx != -1){
                max = Math.max(max, cap1 + p[idx]);
            }
        }
        return max;
        
    }
}