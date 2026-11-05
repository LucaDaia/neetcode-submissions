class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        List<List<Integer>> res = new ArrayList<>();

        int ROWS = heights.length;
        int COLS = heights[0].length;

        boolean[][] pacific = new boolean[ROWS][COLS];
        boolean[][] atlantic = new boolean[ROWS][COLS];

        for(int i = 0; i<ROWS;i++) {
            boolean[][] visited = new boolean[ROWS][COLS];
            dfs(i, 0, ROWS, COLS, pacific, heights,visited,0);
        }

        for(int j=0;j<COLS;j++) {
            boolean[][] visited = new boolean[ROWS][COLS];
            dfs(0, j,ROWS, COLS, pacific, heights,visited,0);
        }

        for(int i = 0; i<ROWS;i++) {
            boolean[][] visited = new boolean[ROWS][COLS];
            dfs(i, COLS-1, ROWS, COLS, atlantic, heights,visited,0);
        }

        for(int j=0;j<COLS;j++) {
            boolean[][] visited = new boolean[ROWS][COLS];
            dfs(ROWS - 1, j, ROWS, COLS, atlantic, heights,visited,0);
        }

        for(int i=0;i<ROWS;i++) {
            for(int j=0;j<COLS;j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    res.add(temp);
                }
            }
        }

        return res;

    }

            public void dfs(int i, int j, int ROWS, int COLS, boolean[][] ocean, int[][] heights, boolean[][] visited, int prev) {

            if(i<0 || j<0 || i>=ROWS || j>= COLS || visited[i][j] == true || heights[i][j] < prev) {
                return;
            }

            visited[i][j] = true;
            ocean[i][j] = true;

            dfs(i+1,j,ROWS,COLS,ocean, heights, visited, heights[i][j]);
            dfs(i-1,j,ROWS,COLS,ocean, heights, visited, heights[i][j]);
            dfs(i,j+1,ROWS,COLS,ocean, heights, visited, heights[i][j]);
            dfs(i,j-1,ROWS,COLS,ocean, heights, visited, heights[i][j]);
        }
}
