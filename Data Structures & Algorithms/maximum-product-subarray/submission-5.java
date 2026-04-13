class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int curMax = nums[0];
        int curMin = nums[0];
        int max = curMax;
        for (int i = 1; i < n; i++) {
            int temp = curMax;
            curMax = Math.max(Math.max(curMax * nums[i], curMin * nums[i]), nums[i]);
            curMin = Math.min(Math.min(temp * nums[i], curMin * nums[i]), nums[i]);

            max = Math.max(max, curMax);
        }
        return max;
    }
}
