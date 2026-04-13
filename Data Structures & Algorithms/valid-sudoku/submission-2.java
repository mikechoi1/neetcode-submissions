class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> seenRows = new ArrayList<>();
        List<Set<Character>> seenCols = new ArrayList<>();
        List<Set<Character>> seenSquares = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            seenRows.add(new HashSet<>());
            seenCols.add(new HashSet<>());
            seenSquares.add(new HashSet<>());
        }

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == '.') {
                    continue;
                }
                if (seenRows.get(r).contains(board[r][c]) ||
                    seenCols.get(c).contains(board[r][c]) ||
                    seenSquares.get(r / 3 * 3 + c / 3).contains(board[r][c])) {
                    return false;
                }
                seenRows.get(r).add(board[r][c]);
                seenCols.get(c).add(board[r][c]);
                seenSquares.get(r / 3 * 3 + c / 3).add(board[r][c]);
            }
        }
        return true;
    }
}
