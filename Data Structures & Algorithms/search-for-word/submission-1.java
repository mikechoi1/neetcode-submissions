class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, visited, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visited, int i, int j, String word, int k) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length ||
            visited[i][j] || board[i][j] != word.charAt(k)) {
            return false;
        }
        if (k == word.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        boolean res = dfs(board, visited, i - 1, j, word, k + 1) ||
                    dfs(board, visited, i + 1, j, word, k + 1) ||
                    dfs(board, visited, i, j - 1, word, k + 1) ||
                    dfs(board, visited, i, j + 1, word, k + 1);
        visited[i][j] = false;

        return res;

    }
}
