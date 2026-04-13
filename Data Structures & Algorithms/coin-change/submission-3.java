class Solution {
    public int coinChange(int[] coins, int amount) {
        // dp where dp[i] = number of coins needed for i amount
        // base case: dp[0] = 0
        //dp : [0, amount]
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i && dp[i - coin] != -1) {
                    if (dp[i] == -1) {
                        dp[i] = dp[i - coin] + 1;
                    }
                    else {
                        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    }
                }
            }
        }
        return dp[amount];
    }
}
