class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new int[] {i - 1, j});
                    queue.offer(new int[] {i + 1, j});
                    queue.offer(new int[] {i, j - 1});
                    queue.offer(new int[] {i, j + 1});
                    break;
                }
            }
        }
        int steps = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] square = queue.poll();
                int r = square[0];
                int c = square[1];
                if (r >= grid.length || c >= grid[0].length || r < 0 ||
                    c < 0 || grid[r][c] != Integer.MAX_VALUE) {
                    continue;
                }
                grid[r][c] = steps;
                queue.offer(new int[] {r - 1, c});
                queue.offer(new int[] {r + 1, c});
                queue.offer(new int[] {r, c - 1});
                queue.offer(new int[] {r, c + 1});
            }
            steps++;
        }
    }
}
