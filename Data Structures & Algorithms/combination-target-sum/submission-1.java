class Solution {

    public List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        // add first num
        // recursion
        // remove first number
        // parameters: nums, target remaining, index, list
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, target, 0, list);
        return res;
    }

    private void dfs(int[] nums, int target, int index, List<Integer> list) {
        // base case: target = 0, add current list to res
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (index == nums.length || target - nums[index] < 0) {
            return;
        }
        // recursive case: add nums at index, recursive call, remove nums at index
        list.add(nums[index]);
        dfs(nums, target - nums[index], index, list);
        list.remove(list.size() - 1);
        dfs(nums, target, index + 1, list);
    }
}
