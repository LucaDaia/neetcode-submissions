class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;

        int ROWS = grid.length;
        int COLS = grid[0].length;

        for(int i=0;i<ROWS;i++) {
            for(int j=0;j<COLS;j++) {
               res = Math.max(res, dfs(i,j,ROWS,COLS, grid)); 
            }
        }

        return res;
    }

    public int dfs(int i, int j, int ROWS, int COLS, int[][] grid) {

        if(i<0 || j<0 || i>= ROWS || j >= COLS || grid[i][j] == 0) {
            return 0;
        }

        grid[i][j] = 0;
        return 1 + dfs(i+1, j, ROWS, COLS, grid) + 
                    dfs(i-1, j, ROWS, COLS, grid) + 
                    dfs(i, j + 1, ROWS, COLS, grid) +
                    dfs(i, j - 1, ROWS, COLS, grid);

    }
}
