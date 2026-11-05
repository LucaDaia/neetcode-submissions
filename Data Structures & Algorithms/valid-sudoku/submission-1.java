class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Integer>[] rowSets = new HashSet[9];
        HashSet<Integer>[] colSets = new HashSet[9];
        HashSet<Integer>[] quadSets = new HashSet[9];

        for(int i=0;i<9;i++) {
            rowSets[i] = new HashSet<>();
            colSets[i] = new HashSet<>();
            quadSets[i] = new HashSet<>();
        }


        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                int quadNr = (i/3) * 3 + j/3;
                if(rowSets[i].contains(Integer.valueOf(board[i][j])) || colSets[j].contains(Integer.valueOf(board[i][j])) 
                || quadSets[quadNr].contains(Integer.valueOf(board[i][j]))) {
                    return false;
                }

                if(board[i][j] != '.') {
                rowSets[i].add(Integer.valueOf(board[i][j]));
                colSets[j].add(Integer.valueOf(board[i][j]));
                quadSets[quadNr].add(Integer.valueOf(board[i][j]));
                }
            }
        }

        return true;
    }
}
