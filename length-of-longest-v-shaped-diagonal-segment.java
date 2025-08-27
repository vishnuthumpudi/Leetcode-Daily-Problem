class Solution {
    public int lenOfVDiagonal(int[][] grid) {
        int res = 0;
        //Map<Pair<Pair<Integer, Integer>, Pair<Integer, Boolean>>, Integer> cache = new HashMap<>(); 
        int[][][][] cache = new int[grid.length][grid[0].length][4][2];
        for (int[][][] c : cache){
            for (int[][] b : c){
                for (int[] a : b){
                    Arrays.fill(a, -1); 
                }
            }
        } 
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1){
                    res = Math.max(res, 1 + dfs(i - 1, j - 1, 0, grid, 0, 0, cache)); 
                    res = Math.max(res, 1 + dfs(i - 1, j + 1, 1, grid, 0, 0, cache));
                    res = Math.max(res, 1 + dfs(i + 1, j - 1, 2, grid, 0, 0, cache));
                    res = Math.max(res, 1 + dfs(i + 1, j + 1, 3, grid, 0, 0, cache));
                }
            }
        }
        return res; 
    }

    private int dfs(int i,int j, int dir, int[][] grid, int used, int prev, int[][][][] cache){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length){
            return 0; 
        }
        if (grid[i][j] != 2 - prev){
            return 0; 
        }
        if (cache[i][j][dir][used] != -1){
            return cache[i][j][dir][used]; 
        }
        int max = 0; 
        if (dir == 0){
            max = Math.max(max, dfs(i - 1, j - 1, 0, grid, used, 2 - prev, cache));
            if (used == 0){
                max = Math.max(max, dfs(i - 1, j + 1, 1, grid, 1, 2 - prev, cache));
            } 
        }  
        if (dir == 1){
            max = Math.max(max, dfs(i - 1, j + 1, 1, grid, used, 2 - prev, cache));
            if (used == 0){
                max = Math.max(max, dfs(i + 1, j + 1, 3, grid, 1, 2 - prev, cache));
            } 
        }     
        if (dir == 2){
            max = Math.max(max, dfs(i + 1, j - 1, 2, grid, used, 2 - prev, cache));
            if (used == 0){
                max = Math.max(max, dfs(i - 1, j - 1, 0, grid, 1, 2 - prev, cache));
            } 
        } 
        if (dir == 3){
            max = Math.max(max, dfs(i + 1, j + 1, 3, grid, used, 2 - prev, cache)); 
            if (used == 0){
                max = Math.max(max, dfs(i + 1, j - 1, 2, grid, 1, 2 - prev, cache)); 
            } 
        }     
        cache[i][j][dir][used] = 1 + max;  
        return 1 + max; 
    }
}
