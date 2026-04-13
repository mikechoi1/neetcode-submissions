class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] coinsNeeded = new int[amount + 1];
        Arrays.fill(coinsNeeded, amount + 1);
        coinsNeeded[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    coinsNeeded[i] = Math.min(coinsNeeded[i], coinsNeeded[i - coin] + 1);
                }
            }
        }
        return coinsNeeded[amount] > amount ? -1 : coinsNeeded[amount];
    }
}
