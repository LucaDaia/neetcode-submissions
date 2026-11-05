class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] colSets = new HashSet[9];
        HashSet<Character>[] rowSets = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];


        for (int i = 0; i < 9; i++) {
            colSets[i] = new HashSet<>();
            rowSets[i] = new HashSet<>();
            boxes[i]   = new HashSet<>();
        }
        int n = board.length;
        int m = board[0].length;

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(colSets[j].contains(board[i][j]) || rowSets[i].contains(board[i][j]) ||
                     boxes[(i/3)*3 + (j/3)].contains(board[i][j])) {
                    return false;
                }

                if(Character.isDigit(board[i][j])) {
                    colSets[j].add(board[i][j]);
                    rowSets[i].add(board[i][j]);
                    boxes[(i/3)*3 + (j/3)].add(board[i][j]);
                }
            }
        }

        return true;
    }
}
