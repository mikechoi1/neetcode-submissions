class Solution {
    public int maxProfit(int[] prices) {
        // 3 states: able to buy, is holding, cooldown
        int[][] dp = new int[3][prices.length];
        dp[0][0] = 0;
        dp[1][0] = -prices[0];
        dp[2][0] = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], dp[2][i - 1]);

            dp[1][i] = Math.max(dp[1][i - 1], dp[0][i - 1] - prices[i]);

            dp[2][i] = dp[1][i - 1] + prices[i];
        }

        return Math.max(dp[0][prices.length - 1], dp[2][prices.length - 1]);
    }
}
