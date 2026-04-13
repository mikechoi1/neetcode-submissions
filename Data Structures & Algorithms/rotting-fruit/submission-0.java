class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }
                else if (grid[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                }
            }
        }
        int time = 0;
        while (!queue.isEmpty() && fresh > 0) {
            time++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] coord = queue.poll();
                int r = coord[0];
                int c = coord[1];
                int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
                for (int[] dir : dirs) {
                    int row = r + dir[0];
                    int col = c + dir[1];
                    if (row < 0 || col < 0 || row == m || col == n || grid[row][col] != 1) {
                        continue;
                    }
                    grid[row][col] = 2;
                    fresh--;
                    queue.offer(new int[] {row, col});
                }
            }
        }
        return fresh == 0 ? time : -1;
    }
}
