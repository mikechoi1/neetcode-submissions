class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> currentSubset = new ArrayList<>();
        backtrack(subsets, currentSubset, nums, 0);
        return subsets;
    }

    private void backtrack(List<List<Integer>> subsets, List<Integer> curSubset, int[] nums, int index) {
        // base case
        if (index == nums.length) {
            subsets.add(new ArrayList<>(curSubset));
            return;
        }

        // recursive case
        curSubset.add(nums[index]);
        backtrack(subsets, curSubset, nums, index + 1);
        curSubset.remove(curSubset.size() - 1);
        backtrack(subsets, curSubset, nums, index + 1);
    }
}
