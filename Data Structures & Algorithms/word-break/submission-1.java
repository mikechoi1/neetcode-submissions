class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.equals("")) {
            return true;
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (String word : wordDict) {
                if (word.length() <= i + 1 && s.substring(i - word.length() + 1, i + 1).equals(word)
                && dp[i - word.length() + 1]) {
                    dp[i + 1] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
