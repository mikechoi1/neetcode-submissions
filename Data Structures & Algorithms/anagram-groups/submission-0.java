class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hashmap = new HashMap<>();
        for (String str : strs) {
            int[] anagram = new int[26];
            for (char c : str.toCharArray()) {
                anagram[c - 'a']++;
            }
            String key = Arrays.toString(anagram);
            hashmap.putIfAbsent(key, new ArrayList<>());
            hashmap.get(key).add(str);
        }
        return new ArrayList<>(hashmap.values());
    }
}
