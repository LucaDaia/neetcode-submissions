class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        int res = 0;
        boolean found = false;

        int n = grid.length;
        int m = grid[0].length;
        
        Queue<Pair<Integer, Integer>> que = new ArrayDeque<>();

        int[][] dirs = {{1,0}, {0,1}, {-1, 0}, {0, -1}, {1,1}, {-1,-1}, {-1, 1}, {1, -1}};

        if(grid[0][0] != 0) return -1;
        que.offer(new Pair(0,0));

        while(!que.isEmpty()) {

            int size = que.size();

            for(int i=0;i<size;i++) {

                Pair<Integer, Integer> polled = que.poll();
                int r = polled.getKey();
                int c = polled.getValue();

                if(r == n-1 && c == m-1) {
                    found = true;
                    return res+1;
                } 

                for(int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if(nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == 0) {
                        que.offer(new Pair(nr,nc));
                        grid[nr][nc] = 2;
                    }
                }
            }

            res++;

        }

        return found == true ? res : -1;
    }
}