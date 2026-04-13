class Solution {

    public List<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayList<>());
        return res;

    }

    private void dfs(int[] cand, int target, int i, List<Integer> list) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
        }
        if (i == cand.length || target - cand[i] < 0) {
            return;
        }
        list.add(cand[i]);
        dfs(cand, target - cand[i], i + 1, list);
        list.remove(list.size() - 1);
        while (i + 1 < cand.length && cand[i] == cand[i + 1]) {
            i++;
        }
        dfs(cand, target, i + 1, list);
    }
}
