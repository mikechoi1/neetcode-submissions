class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        char[] c = s.toCharArray();
        while (i < j) {
            if (!Character.isLetterOrDigit(c[i])) {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(c[j])) {
                j--;
                continue;
            }
            
            if (Character.toLowerCase(c[i]) != Character.toLowerCase(c[j])) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
