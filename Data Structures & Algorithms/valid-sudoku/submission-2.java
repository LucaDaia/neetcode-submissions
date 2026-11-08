class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (cols[j].contains(board[i][j]) || rows[i].contains(board[i][j])
                    || boxes[(i / 3) * 3 + (j / 3)].contains(board[i][j])) {
                    return false;
                } else {
                    if (Character.isDigit(board[i][j])) {
                        cols[j].add(board[i][j]);
                        rows[i].add(board[i][j]);
                        boxes[(i / 3) * 3 + (j / 3)].add(board[i][j]);
                    }
                }
            }
        }

        return true;
    }
}
