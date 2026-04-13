class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(helper(Arrays.copyOfRange(nums, 0, nums.length - 1)), 
        helper(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    private int helper(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] max = new int[nums.length];
        max[0] = nums[0];
        max[1] = Math.max(max[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            max[i] = Math.max(max[i-1], max[i-2] + nums[i]);
        }
        return max[nums.length - 1];
    }
}
