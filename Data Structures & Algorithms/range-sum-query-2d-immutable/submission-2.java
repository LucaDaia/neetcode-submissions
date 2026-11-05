class NumMatrix {
    int[][] prefixMatrix;

    public NumMatrix(int[][] matrix) {

        prefixMatrix = new int[matrix.length][matrix[0].length];

        for(int i = 0; i< matrix.length; i++) {
            for(int j=0;j<matrix[0].length;j++) {
                prefixMatrix[i][j] = 0;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            int sum = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                sum += matrix[i][j];
                if (i < 1) {
                    prefixMatrix[i][j] = sum;
                } else {
                    prefixMatrix[i][j] = sum + prefixMatrix[i - 1][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        int res = 0;

        if(row1==0 && col1==0) return prefixMatrix[row2][col2];

        if(row1 == 0 && col1 != 0) {
            res = prefixMatrix[row2][col2] - prefixMatrix[row2][col1 - 1];
            return res;
        }

        if(row1 != 0 && col1 == 0) {
            res = prefixMatrix[row2][col2] - prefixMatrix[row1 - 1][col2];
            return res;
        }
        
        res = prefixMatrix[row2][col2];
        res = res - (prefixMatrix[row1 - 1][col2] + prefixMatrix[row2][col1 - 1]);
        res = res + prefixMatrix[row1 - 1][col1 - 1];

        return res;

    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */