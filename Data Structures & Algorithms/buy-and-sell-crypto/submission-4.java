class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;

        int l = 0;
        
        for(int r=1;r<prices.length;r++) {
            res = Math.max(res, prices[r] - prices[l]);

            if(prices[r] < prices[l]) {
                l = r;
            }
        }

        return res;
    }
}
