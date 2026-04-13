class Solution {
    public int maxProfit(int[] prices) {
        // 3 states: able to buy, able to sell, cooldown
        int[][] dp = new int[3][prices.length + 1];
        for (int i = prices.length - 1; i >= 0; i--) {
            // state 1: can buy
            int buy = dp[1][i + 1] - prices[i];
            int dontBuy = dp[0][i + 1];
            dp[0][i] = Math.max(buy, dontBuy);

            // state 2: can sell
            int sell = dp[2][i + 1] + prices[i];
            int dontSell = dp[1][i + 1];
            dp[1][i] = Math.max(sell, dontSell);

            // state 3: on cooldown
            dp[2][i] = dp[0][i + 1];
        }
        return dp[0][0];
    }
}
