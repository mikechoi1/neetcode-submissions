class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            queue.offer(i * n);
        }
        for (int j = 0; j < n; j++) {
            queue.offer(j);
        }
        Set<Integer> hashsetP = coordReached(heights, queue);

        for (int i = 0; i < m; i++) {
            queue.offer(i * n + n - 1);
        }

        for (int j = 0; j < n; j++) {
            queue.offer((m - 1) * n + j);
        }
        Set<Integer> hashsetA = coordReached(heights, queue);

        List<List<Integer>> res = new ArrayList<>();
        for (int coord : hashsetP) {
            if (hashsetA.contains(coord)) {
                res.add(List.of(coord / n, coord % n));
            }
        }
        return res;
    }


    private Set<Integer> coordReached(int[][] heights, Queue<Integer> queue) {
        int m = heights.length;
        int n = heights[0].length;
        Set<Integer> hashset = new HashSet<>();
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            int r = poll / n;
            int c = poll % n;
            if (hashset.contains(poll) || r < 0 || c < 0 ||
            r == m || c == n) {
                continue;
            }
            hashset.add(poll);
            if (r != 0 && heights[r - 1][c] >= heights[r][c]) {
                queue.offer(poll - n);
            }
            if (r < m - 1 && heights[r + 1][c] >= heights[r][c]) {
                queue.offer(poll + n);
            }
            if (c != 0 && heights[r][c - 1] >= heights[r][c]) {
                queue.offer(poll - 1);
            }
            if (c < n - 1 && heights[r][c + 1] >= heights[r][c]) {
                queue.offer(poll + 1);
            }
        }
        return hashset;
    }
}
