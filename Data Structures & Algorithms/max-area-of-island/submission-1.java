class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int res = 0;
        int[] cur = new int[1];
        // would this change the original matrix?

        for(int i=0;i<rows; i++) {
            for(int j=0;j<cols;j++) {
                if(grid[i][j] == 1) {
                    cur[0] = 0;
                    dfs(grid, i, j, rows, cols, cur);
                    res = Math.max(res, cur[0]);
                }
            }
        }

        return res;
    }

    private void dfs(int[][] grid, int i, int j, int rows, int cols, int[] cur) {
        if(i < 0 || j < 0 || i>= rows || j >= cols || grid[i][j] == 0) {
            return;
        }

        grid[i][j] = 0;
        cur[0]++;
        dfs(grid, i, j-1, rows, cols, cur);
        dfs(grid, i ,j+1, rows, cols, cur);
        dfs(grid, i-1, j, rows, cols, cur);
        dfs(grid, i+1, j, rows, cols, cur);
    }
}
