class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        // <sum, count>
        Map<Integer, Integer>[] dp = new Map[n + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new HashMap<>();
        }
        // initialize dp
        dp[0].put(0, 1);
        for (int i = 0; i < n; i++) {
            for (Map.Entry<Integer, Integer> entry : dp[i].entrySet()) {
                int sum = entry.getKey();
                int count = entry.getValue();

                dp[i + 1].put(sum + nums[i], dp[i + 1].getOrDefault(sum + nums[i], 0) + count);
                dp[i + 1].put(sum - nums[i], dp[i + 1].getOrDefault(sum - nums[i], 0) + count);
            }
        }
        return dp[n].getOrDefault(target, 0);

    }
}