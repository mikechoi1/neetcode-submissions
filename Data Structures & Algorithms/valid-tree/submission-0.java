class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        Set<Integer> hashset = new HashSet<>();
        if (!dfs(0, -1, hashset, adj)) {
            return false;
        }
        return hashset.size() == n;
    }

    private boolean dfs(int node, int parent, Set<Integer> hashset, List<List<Integer>> adj) {
        if (hashset.contains(node)) {
            return false;
        }
        hashset.add(node);
        for (int childNode : adj.get(node)) {
            if (childNode == parent) {
                continue;
            }
            if (!dfs(childNode, node, hashset, adj)) {
                return false;
            }
        }
        return true;
    }
}
