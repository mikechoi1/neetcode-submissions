class Solution {
    public int maxProfit(int[] prices) {
        int left = 0, right = 1;
        int maxProfit = 0;
        while (right < prices.length) {
            if (prices[right] < prices[left]) {
                left = right;
            }
            maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
            right++;
        }
        return maxProfit;
    }
}
