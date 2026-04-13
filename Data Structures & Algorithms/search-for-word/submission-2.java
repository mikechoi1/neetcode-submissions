class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(i, j, board, new boolean[board.length][board[0].length], 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, char[][] board, boolean[][] visited, int index, String word) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length ||
            visited[i][j] || board[i][j] != word.charAt(index)) {
                return false;
        }
        visited[i][j] = true;
        boolean result = dfs(i-1, j, board, visited, index + 1, word) ||
                         dfs(i+1, j, board, visited, index + 1, word) ||
                         dfs(i, j-1, board, visited, index + 1, word) ||
                         dfs(i, j+1, board, visited, index + 1, word);
        visited[i][j] = false;
        return result;
    }
}
