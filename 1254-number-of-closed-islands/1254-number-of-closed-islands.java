class Solution {
    private void dfs(int x,int y,int[][] grid){
        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
        for(int[] d:dirs){
            int dx = d[0] + x;
            int dy = d[1] + y;
            if(dx < grid.length && dx >= 0 && dy < grid[0].length && dy >= 0 && grid[dx][dy] != 1){
                grid[dx][dy] = 1;
                dfs(dx,dy,grid);
            }
        }
    }
    public int closedIsland(int[][] grid) {
        int n = grid.length ; 
        int m = grid[0].length ;

        for(int i = 0 ; i < n ; ++i){
            if(grid[i][0] == 0){
                grid[i][0] = 1;
                dfs(i,0,grid);
            }
            if(grid[i][m-1] == 0){
                grid[i][m-1] = 1;
                dfs(i,m-1,grid);
            }
        }
        for(int i = 0 ; i < m ; ++i){
            if(grid[0][i] == 0){
                grid[0][i] = 1;
                dfs(0,i,grid);
            }
            if(grid[n-1][i] == 0){
                grid[n-1][i] = 1;
                dfs(n-1,i,grid);
            }
        }
        int res = 0;
        for(int i = 1 ; i < n - 1  ; ++i){
            for(int j = 1 ; j < m - 1 ; ++j){
                if(grid[i][j] == 0){
                    ++res;
                    dfs(i,j,grid);
                }
            }
        }
        return res;
    }
}