class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n < 1) return 0;
        int dp[]  = new int[n];
        int res = 1;
        for(int i=0; i< n;i++) {
            dp[i] = 1;
            for(int j= 0; j<i;j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    
                }
                res = Math.max(dp[i], res);
            }

        }

        return res;
        
    }
}
