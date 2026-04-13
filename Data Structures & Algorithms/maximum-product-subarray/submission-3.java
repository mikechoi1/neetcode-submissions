class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][0] = nums[0];
        int max = nums[0];
        if (nums[0] < 0) {
            dp[0][1] = nums[0];
        }
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                dp[i][0] = Math.max(nums[i], dp[i-1][0] * nums[i]);
                dp[i][1] = Math.min(nums[i], dp[i-1][1] * nums[i]);
                max = Math.max(max, dp[i][0]);
            }
            else if (nums[i] < 0) {
                dp[i][0] = Math.max(nums[i], dp[i-1][1] * nums[i]);
                dp[i][1] = Math.min(nums[i], dp[i-1][0] * nums[i]);
                max = Math.max(max, dp[i][0]);
            }
            else {
                max = Math.max(max, nums[i]);
            }

        }
        return max;
    }
}
