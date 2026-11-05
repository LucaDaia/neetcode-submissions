class Solution {
    public void solve(char[][] board) {

        int ROWS = board.length;
        int COLS = board[0].length;

        boolean[][] markedToKeep = new boolean[ROWS][COLS];

        for(int i=0;i<ROWS;i++) {
            dfs(i,0,ROWS,COLS,markedToKeep,board);
            dfs(i,COLS-1,ROWS,COLS,markedToKeep,board);
        }

        for(int j=0;j<COLS;j++) {
            dfs(0,j,ROWS,COLS,markedToKeep,board);
            dfs(ROWS-1,j,ROWS,COLS,markedToKeep,board);
        }


        for(int i=0;i<ROWS;i++) {
            for(int j=0;j<COLS;j++) {
                if(board[i][j] == 'O' && !markedToKeep[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(int i,int j,int ROWS, int COLS, boolean[][] markedToKeep, char[][] board) {

        if(i<0 || j<0 || i>=ROWS || j>=COLS || markedToKeep[i][j] || board[i][j] == 'X') {
            return;
        }

        markedToKeep[i][j] = true;
        dfs(i+1,j,ROWS,COLS,markedToKeep,board);
        dfs(i-1,j,ROWS,COLS,markedToKeep,board);
        dfs(i,j+1,ROWS,COLS,markedToKeep,board);
        dfs(i,j-1,ROWS,COLS,markedToKeep,board);
    }



}
