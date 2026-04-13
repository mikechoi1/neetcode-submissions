class Solution {

    public List<List<Integer>> combinations;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        combinations = new ArrayList<>();
        List<Integer> curCombo = new ArrayList<>();
        backtrack(curCombo, nums, target, 0);
        return combinations;
    }

    private void backtrack(List<Integer> curCombo, int[] nums, int target, int index) {
        // base case
        if (target == 0) {
            combinations.add(new ArrayList<>(curCombo));
            return;
        }
        if (target < 0 || index >= nums.length) {
            return;
        }
        // recursive case
        curCombo.add(nums[index]);
        backtrack(curCombo, nums, target - nums[index], index);
        curCombo.remove(curCombo.size() - 1);
        backtrack(curCombo, nums, target, index + 1);
    }
}
