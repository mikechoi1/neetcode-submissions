class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> hashmap = new HashMap<>();
        char[] letters = s.toCharArray();
        int longest = 0, l = 0, maxFreqSeen = 0;
        for (int r = 0; r < letters.length; r++) {
            hashmap.put(letters[r], hashmap.getOrDefault(letters[r], 0) + 1);
            maxFreqSeen = Math.max(maxFreqSeen, hashmap.get(letters[r]));
            if ((r - l + 1) - maxFreqSeen > k) {
                hashmap.put(letters[l], hashmap.get(letters[l]) - 1);
                l++;
            }
            longest = Math.max(longest, r - l + 1);
        }
        return longest;
    }
}
