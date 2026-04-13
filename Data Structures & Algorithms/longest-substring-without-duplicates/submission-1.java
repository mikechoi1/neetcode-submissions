class Solution {
    public int lengthOfLongestSubstring(String s) {
        // <letter, index>
        Map<Character, Integer> hashmap = new HashMap<>();
        int longest = 0;
        int start = 0;
        char[] letters = s.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            if (hashmap.containsKey(letters[i])) {
                start = Math.max(start, hashmap.get(letters[i]) + 1);
            }
            hashmap.put(letters[i], i);
            longest = Math.max(longest, i - start + 1);
        }
        return longest;
    }
}

// start = 2 l = 2 (a, 0), (b, 2)
