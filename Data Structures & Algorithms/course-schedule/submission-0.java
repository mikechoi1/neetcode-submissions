class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        Map<Integer, List<Integer>> hashmap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            hashmap.put(i, new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            hashmap.get(pre[0]).add(pre[1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(hashmap, visited, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(Map<Integer, List<Integer>> hashmap, boolean[] visited, int i) {
        if (visited[i]) {
            return false;
        }
        if (hashmap.get(i).isEmpty()) {
            return true;
        }
        visited[i] = true;
        for (int prereq : hashmap.get(i)) {
            if (!dfs(hashmap, visited, prereq)) {
                return false;
            }
        }
        visited[i] = false;
        hashmap.put(i, new ArrayList<>());
        return true;
    }
}
