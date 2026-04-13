class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> hashset = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        int maxLen = 0;
        for (String word : wordDict) {
            maxLen = Math.max(maxLen, word.length());
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int len = 1; len <= maxLen && len <= i; len++) {
                if (dp[i - len] && hashset.contains(s.substring(i - len, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
