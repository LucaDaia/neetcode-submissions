class Solution {
    public int minCostClimbingStairs(int[] cost) {

        if(cost.length == 0) return 0;
        if(cost.length == 1) return cost[1];
        if(cost.length == 2) return Math.min(cost[0], cost[1]);
        
        int[] dp = new int[cost.length];

        dp[0] = 0;
        dp[1] = 0;
        dp[2] = Math.min(cost[0], cost[1]);
        
        for(int i = 3;i<cost.length; i++) {
            dp[i] = Math.min(dp[i-2] + cost[i-2], dp[i-1] + cost[i-1]);
        }

        return Math.min(dp[cost.length - 2] + cost[cost.length - 2], dp[cost.length - 1] + cost[cost.length - 1]);
    }
}
