class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] s1Map = new int[26];
        int[] s2Map = new int[26];

        for (char c : s1.toCharArray()) {
            s1Map[c - 'a']++;
        }
        for (int i = 0; i < s1.length(); i++) {
            s2Map[s2.charAt(i) - 'a']++;
        }
        int matchCount = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Map[i] == s2Map[i]) {
                matchCount++;
            }
        }
        if (matchCount == 26) {
            return true;
        }
        int l = 0;
        for (int r = s1.length(); r < s2.length(); r++) {
            int index = s2.charAt(r) - 'a';
            s2Map[index]++;
            if (s2Map[index] == s1Map[index]) {
                matchCount++;
            }
            else if (s2Map[index] == s1Map[index] + 1) {
                matchCount--;
            }
            index = s2.charAt(l) - 'a';
            s2Map[index]--;
            if (s2Map[index] == s1Map[index]) {
                matchCount++;
            }
            else if (s2Map[index] == s1Map[index] - 1) {
                matchCount--;
            }
            if (matchCount == 26) {
                return true;
            }
            l++;
        }
        return false;
    }
}
