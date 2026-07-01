class Solution {
    static final int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();

        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1)
            return 0;

        int[][] a= new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = grid.get(i).get(j);

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (a[i][j] == 1)
                    q.add(new int[]{i, j});

        while (q.size() > 0) {
            int[] head = q.poll();
            int i = head[0];
            int j = head[1];
            int v = a[i][j];

            for (int[] d : dirs) {
                int x = i + d[0];
                int y = j + d[1];

                if (Math.min(x, y) >= 0 && Math.max(x, y) < n && a[x][y] == 0) {
                    a[x][y] = v + 1;
                    q.add(new int[]{x, y});
                }
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        pq.add(new int[]{a[0][0], 0, 0});

        while (pq.size() > 0) {
            int[] head = pq.poll();
            int sf = head[0];
            int i = head[1];
            int j = head[2];

            if (i == n - 1 && j == n - 1)
                return sf - 1;

            for (int[] d : dirs) {
                int x = i + d[0];
                int y = j + d[1];

                if (Math.min(x, y) >= 0 && Math.max(x, y) < n && a[x][y] > 0) {
                    pq.add(new int[]{Math.min(sf, a[x][y]), x, y});
                    a[x][y] *= -1;
                }
            }
        }

        return a[n - 1][n - 1] - 1;
    }
}