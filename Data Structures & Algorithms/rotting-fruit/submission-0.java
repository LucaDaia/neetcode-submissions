class Solution {
    public int orangesRotting(int[][] grid) {
        int res = 0;
        Queue<Pair<Integer, Integer>> q = new ArrayDeque<>();
        int fresh = 0;

        int ROWS = grid.length;
        int COLS = grid[0].length;

        for(int i=0;i<ROWS;i++) {
            for(int j=0;j<COLS;j++) {
                if(grid[i][j] == 2) {
                    q.offer(new Pair(i,j));
                }
                if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        while(!q.isEmpty() && fresh >0) {
            int size = q.size();
            for(int k=0;k<size;k++) {

                Pair<Integer,Integer> temp = q.poll();
                int i = temp.getKey();
                int j = temp.getValue();

                if(i+1<ROWS && grid[i+1][j] == 1) {
                    grid[i+1][j] = 2;
                    fresh--;
                    q.offer(new Pair(i+1, j));
                }
                if(i-1>=0 && grid[i-1][j] == 1) {
                    grid[i-1][j] = 2;
                    fresh--;
                    q.offer(new Pair(i-1,j));
                }
                if(j+1<COLS && grid[i][j+1] == 1) {
                    grid[i][j+1] = 2;
                    fresh--;
                    q.offer(new Pair(i,j+1));
                }
                if(j-1>=0 && grid[i][j-1] == 1) {
                    grid[i][j-1] = 2;
                    fresh--;
                    q.offer(new Pair(i,j-1));
                }
            }
            res++;
        }

        return fresh == 0 ? res : -1;
    }
}
