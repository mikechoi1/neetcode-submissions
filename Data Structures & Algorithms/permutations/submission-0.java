class Solution {

    List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        dfs(nums, new ArrayList<>(), new HashSet<>());
        return res;
    }

    private void dfs(int[] nums, List<Integer> list, Set<Integer> hashset) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (!hashset.contains(j)) {
                hashset.add(j);
                list.add(nums[j]);
                dfs(nums, list, hashset);
                hashset.remove(j);
                list.remove(list.size() - 1);
            }
        }
    }
}
