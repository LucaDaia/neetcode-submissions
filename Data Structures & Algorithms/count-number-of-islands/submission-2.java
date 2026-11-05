class Solution {
    public int numIslands(char[][] grid) {
        
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int res = 0;

        for(int i=0;i<ROWS;i++) {
            for(int j=0;j<COLS;j++) {
                if(grid[i][j] == '1') {
                    dfs(i,j,ROWS,COLS,grid);
                    res++;
                }
            }
        }

        return res;
    }

    public void dfs(int i, int j, int ROWS, int COLS, char[][] grid) {

        if(i<0 || i >=ROWS || j<0 || j>=COLS || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';

        dfs(i+1,j,ROWS,COLS,grid);
        dfs(i-1,j,ROWS,COLS,grid);
        dfs(i,j+1,ROWS,COLS,grid);
        dfs(i,j-1,ROWS,COLS,grid);
    }
}
