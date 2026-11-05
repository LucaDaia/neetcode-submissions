class Solution {
    public int maxProfit(int[] prices) {
        int right = 1;
        int left = 0;
        int res = 0;

        while(left < prices.length && right< prices.length) {
            res = Math.max(prices[right] - prices[left], res);
            if(prices[right] < prices[left]) {
                left = right;
            }
            right++;
        }

        return res;
    }
}
