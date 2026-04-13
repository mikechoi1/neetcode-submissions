class Solution {
    public String longestPalindrome(String s) {
        int maxLenL = 0, maxLenR = 0;
        for (int i = 0; i < s.length(); i++) {
            // for odd palindromes
            int l = i, r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (maxLenR - maxLenL < r - l) {
                    maxLenL = l;
                    maxLenR = r;
                }
                l--;
                r++;
            }
            // for even palindromes
            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (maxLenR - maxLenL < r - l) {
                    maxLenL = l;
                    maxLenR = r;
                }
                l--;
                r++;
            }
        }
        return s.substring(maxLenL, maxLenR + 1);
    }
}
