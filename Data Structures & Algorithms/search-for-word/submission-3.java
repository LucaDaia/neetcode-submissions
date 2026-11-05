class Solution {
    public boolean exist(char[][] board, String word) {
        
        int n = board.length;
        int m = board[0].length;

        boolean res = false;

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
               if(board[i][j] == word.charAt(0)) {
                    boolean[][] seen = new boolean[n][m];
                    res = dfs(0,i,j,n, m, seen, board, word);
               }

               if(res) return true;
            }
        }

        return false;
    }

    public boolean dfs(int index, int i, int j,int n, int m, boolean[][] seen, char[][] board, String word) {

        if(i<0 || j<0 || i>=n || j>=m || index >= word.length() || seen[i][j] == true || board[i][j] != word.charAt(index)) {
            return false;
        }

        if(index == word.length() - 1) return true;

        seen[i][j] = true;
        boolean res = dfs(index + 1, i, j+1, n, m, seen, board, word) ||
               dfs(index + 1, i, j-1, n, m, seen, board, word) ||
               dfs(index + 1, i - 1, j, n, m, seen, board, word) ||
               dfs(index + 1, i + 1, j, n, m, seen, board, word);

        seen[i][j] = false;
        return res;
    }
}
