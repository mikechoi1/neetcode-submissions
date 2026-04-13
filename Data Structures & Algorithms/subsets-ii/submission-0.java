class Solution {

    public List<List<Integer>> res;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        res = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int i, List<Integer> list) {
        if (i == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        dfs(nums, i + 1, list);
        list.remove(list.size() - 1);
        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }
        dfs(nums, i + 1, list);
    }
}
