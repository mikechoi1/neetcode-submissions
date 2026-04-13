class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> hashmapS = new HashMap<>(), hashmapT = new HashMap<>();
        char[] charS = s.toCharArray(), charT = t.toCharArray();
        if (charS.length != charT.length) {
            return false;
        }
        for (int i = 0; i < charS.length; i++) {
            hashmapS.put(charS[i], hashmapS.getOrDefault(charS[i], 0) + 1);
            hashmapT.put(charT[i], hashmapT.getOrDefault(charT[i], 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : hashmapS.entrySet()) {
            char key = entry.getKey();
            if (!hashmapT.containsKey(key)) {
                return false;
            }
            if (!hashmapT.get(key).equals(entry.getValue())) {
                return false;
            }
        }
        return true;
    }
}
