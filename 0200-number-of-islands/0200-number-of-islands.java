class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        if(n==0){
            return 0;
        }
        int island=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                        island++;
                    
                }
            }
        }
        return island;
    }
    public static void dfs(char[][] grid,int i,int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || '0'-grid[i][j]==0){
            return;
        }
        grid[i][j]='0';
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }
}