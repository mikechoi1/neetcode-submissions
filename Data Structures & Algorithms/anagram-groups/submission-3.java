class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hashmap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            int[] letterCount = new int[26];
            for (char c : strs[i].toCharArray()) {
                letterCount[c - 'a']++;
            }
            String key = Arrays.toString(letterCount);
            hashmap.putIfAbsent(key, new ArrayList<>());
            hashmap.get(key).add(strs[i]);
        }
        return new ArrayList<>(hashmap.values());
    }
}
