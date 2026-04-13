class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[0] = 1;
                }
                else {
                    dp[j] += dp[j-1];
                }
            }
        }
        return dp[n-1];
    }
}
