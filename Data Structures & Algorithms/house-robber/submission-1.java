class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int[] maxMoney = new int[n];
        maxMoney[0] = nums[0];
        maxMoney[1] = Math.max(maxMoney[0], nums[1]);
        for (int i = 2; i < n; i++) {
            maxMoney[i] = Math.max(maxMoney[i - 1], maxMoney[i - 2] + nums[i]);
        }
        return maxMoney[n - 1];
    }
}
