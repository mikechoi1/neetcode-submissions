class Solution {
    public int maxProfit(int[] prices) {
        // sub problem: max profit if we start on ith day to end
        // base case: start on nth day (0 profit for all 3 states)
        // 3 states: can buy, holding, cooldown
        int n = prices.length;
        int canBuy = 0, holding = 0, cooldown = 0;
        for (int i = n - 1; i >= 0; i--) {
            // state 1: can buy
            int tempBuy = canBuy;
            canBuy = Math.max(holding - prices[i], canBuy);

            // state 2: is holding
            holding = Math.max(cooldown + prices[i], holding);

            // state 3: cooldown
            cooldown = tempBuy;
        }
        return canBuy;
    }
}
