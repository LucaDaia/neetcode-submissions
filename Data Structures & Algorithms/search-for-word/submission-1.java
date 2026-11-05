class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(0, i, j, n, m, visited, board, word)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(int idx, int i, int j, int n, int m,
                       boolean[][] visited, char[][] board, String word) {

        // bounds + visited + mismatch
        if (i < 0 || j < 0 || i >= n || j >= m ||
            visited[i][j] || board[i][j] != word.charAt(idx)) {
            return false;
        }

        // if last character matched
        if (idx == word.length() - 1) {
            return true;
        }

        visited[i][j] = true;

        boolean found =
               dfs(idx + 1, i + 1, j, n, m, visited, board, word) || // down
               dfs(idx + 1, i - 1, j, n, m, visited, board, word) || // up
               dfs(idx + 1, i, j - 1, n, m, visited, board, word) || // left
               dfs(idx + 1, i, j + 1, n, m, visited, board, word);   // right

        visited[i][j] = false;   // 🔑 backtrack

        return found;
    }
}
