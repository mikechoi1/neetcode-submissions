class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int n = coins.length;
        int[] coinsNeeded = new int[amount + 1];
        Arrays.fill(coinsNeeded, -1);
        for (int i = 1; i < amount + 1; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (coin == i) {
                    min = 1;
                    break;
                }
                else if (coin < i && coinsNeeded[i - coin] != -1) {
                    min = Math.min(min, coinsNeeded[i - coin] + 1);
                }
            }
            if (min == Integer.MAX_VALUE) {
                coinsNeeded[i] = -1;
            }
            else coinsNeeded[i] = min;

        }
        return coinsNeeded[amount];
    }
}
