class NumMatrix {

    Map<Integer, int[]> prefixMap = new HashMap<>();

    public NumMatrix(int[][] matrix) {
        prefixMap = new HashMap<>();

        for(int i = 0; i<matrix.length; i++) {
            prefixMap.put(i, calcPrefix(matrix[i]));
        }
    }

    public int[] calcPrefix(int[] nums) {
        int sum=0;
        int[] res = new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            sum+=nums[i];
            res[i] = sum;
        }

        return res;
    }
    
public int sumRegion(int row1, int col1, int row2, int col2) {
    int sumRes = 0;

    for (int i = row1; i <= row2; i++) {
        int[] prefix = prefixMap.get(i);

        if (col1 == 0) {
            sumRes += prefix[col2];
        } else {
            sumRes += prefix[col2] - prefix[col1 - 1];
        }
    }

    return sumRes;
}
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */