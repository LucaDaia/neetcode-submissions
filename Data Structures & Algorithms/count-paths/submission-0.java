class Solution {
    public int uniquePaths(int m, int n) {
        int[] res = new int[1];
        res[0] = 0;
        backtracking(m,n, 0,0, res);
        return res[0];
    }

    public void backtracking(int m, int n,int i, int j, int[] res) {
        if(i>m - 1 || j > n - 1) return;

        if(i == m - 1 && j == n - 1) {res[0]++; return;}

        backtracking(m,n,i+1,j,res);
        backtracking(m,n,i,j+1,res);
    }


}
