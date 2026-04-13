class Solution {
    public int maxProfit(int[] prices) {
        // 3 states: able to buy, is holding, cooldown
        int[][] dp = new int[3][prices.length];
        int canBuy = 0;
        int holding = -prices[0];
        int cooldown = Integer.MIN_VALUE;
        dp[0][0] = 0;
        dp[1][0] = -prices[0];
        dp[2][0] = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            int tempBuy = canBuy;
            canBuy = Math.max(canBuy, cooldown);
            // dp[0][i] = Math.max(dp[0][i - 1], dp[2][i - 1]);
            int tempHold = holding;
            holding = Math.max(holding, tempBuy - prices[i]);
            // dp[1][i] = Math.max(dp[1][i - 1], dp[0][i - 1] - prices[i]);
            cooldown = holding + prices[i];
            // dp[2][i] = dp[1][i - 1] + prices[i];
        }

        return Math.max(canBuy, cooldown);
    }
}
