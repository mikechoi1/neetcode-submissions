class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();
        for (String str : strs) {
            Map<Character, Integer> letterMap = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                char letter = str.charAt(i);
                letterMap.put(letter, letterMap.getOrDefault(letter, 0) + 1);
            }
            String anagramKey = letterMap.toString();
            anagramMap.putIfAbsent(anagramKey, new ArrayList<>());
            anagramMap.get(anagramKey).add(str);
        }
        return new ArrayList<>(anagramMap.values());
    }
}
