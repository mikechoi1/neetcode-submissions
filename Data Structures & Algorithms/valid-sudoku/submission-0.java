class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> checkRows = new ArrayList<>();
        List<Set<Character>> checkCols = new ArrayList<>();
        List<Set<Character>> checkSquares = new ArrayList<>();
        
        for (int i = 0; i < board.length; i++) {
            checkRows.add(new HashSet<>());
            checkCols.add(new HashSet<>());
            checkSquares.add(new HashSet<>());
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char value = board[i][j];
                if (value == '.') {
                    continue;
                }
                if (checkRows.get(i).contains(value)) {
                    return false;
                }
                checkRows.get(i).add(value);
                if (checkCols.get(j).contains(value)) {
                    return false;
                }
                checkCols.get(j).add(value);
                int squareIndex = i / 3 * 3 + j / 3;
                if (checkSquares.get(squareIndex).contains(value)) {
                    return false;
                }
                checkSquares.get(squareIndex).add(value);
            }
        }
        return true;
    }
}
