class Solution {
    public boolean isAnagram(String s, String t) {
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }

        for(char c : t.toCharArray()) {
            int index = c - 'a';
            if (counts[index] == 0) {
                return false;
            }
            counts[index]--;
        }
        
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
