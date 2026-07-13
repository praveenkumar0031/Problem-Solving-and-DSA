class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] visited = new int[n];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                dfs(i, isConnected, visited);
                cnt++;
            }
        }
        return cnt;
    }

    private void dfs(int node, int[][] isConnected, int[] visited) {
        visited[node] = 1;
        for (int neighbor = 0; neighbor < isConnected.length; neighbor++) {
            if (isConnected[node][neighbor] == 1 && visited[neighbor] == 0) {
                dfs(neighbor, isConnected, visited);
            }
        }
    }
}