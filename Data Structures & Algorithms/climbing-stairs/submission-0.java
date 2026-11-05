class Solution {
    public int climbStairs(int n) {
        
       return dfs(n);
    }

    public int dfs(int n) {
        if(n == 1 ||n == 0) {
            return 1;
        }

        return dfs(n-1) + dfs(n-2);
    }
}
