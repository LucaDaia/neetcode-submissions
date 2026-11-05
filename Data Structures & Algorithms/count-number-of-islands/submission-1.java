class Solution {
    public int numIslands(char[][] grid) {
       
        int res = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for(int i = 0; i< rows; i++) {
            for(int j=0; j<cols; j++) {
                if(dfs(i, j, rows, cols, grid)) {
                    res++;
                }
            }
        }

        return res;

    }

    private boolean dfs(int i, int j, int rows, int cols, char[][] grid) {

        if(i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == '0') {
            return false;
        }

        grid[i][j] = '0';
        dfs(i-1, j, rows, cols, grid);
        dfs(i+1, j, rows, cols,grid);
        dfs(i, j+1, rows, cols, grid);
        dfs(i, j-1, rows, cols, grid);

        return true;
    }
}
