class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.isEmpty()) {
            return combinations;
        }
        String[] digitToChar = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        backtrack(0, digits, digitToChar, new StringBuilder(), combinations);
        return combinations;
    }

    private void backtrack(int index, String digits, String[] digitToChar, StringBuilder curString, List<String> combinations) {
        //base case
        if (curString.length() == digits.length()) {
            combinations.add(new StringBuilder(curString).toString());
            return;
        } 
        String charset = digitToChar[digits.charAt(index) - '0'];
        for (int i = 0; i < charset.length(); i++) {
            curString.append(charset.charAt(i));
            backtrack(index + 1, digits, digitToChar, curString, combinations);
            curString.setLength(curString.length() - 1);
        }
    }
}
