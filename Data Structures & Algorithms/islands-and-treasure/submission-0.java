class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        int ROWS = grid.length;
        int COLS = grid[0].length;

        // Add all gates
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == 0) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0], c = cell[1];

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nr >= ROWS || nc < 0 || nc >= COLS) continue;
                if (grid[nr][nc] != Integer.MAX_VALUE) continue;

                grid[nr][nc] = grid[r][c] + 1;
                q.offer(new int[]{nr, nc});
            }
        }
    }
}
