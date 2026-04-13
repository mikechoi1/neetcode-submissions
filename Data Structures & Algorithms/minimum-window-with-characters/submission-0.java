class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> sHashmap = new HashMap<>();
        Map<Character, Integer> tHashmap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tHashmap.put(c, tHashmap.getOrDefault(c, 0) + 1);
        }
        int[] res = new int[] {0, Integer.MAX_VALUE};
        int need = tHashmap.size();
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            sHashmap.put(c, sHashmap.getOrDefault(c, 0) + 1);
            if (tHashmap.containsKey(c) && tHashmap.get(c) == sHashmap.get(c)) {
                need--;
            }
            while (need == 0) {
                if (r - l <= res[1] - res[0]) {
                    res[0] = l;
                    res[1] = r;
                }
                char leftChar = s.charAt(l);
                sHashmap.put(leftChar, sHashmap.get(leftChar) - 1);
                if (tHashmap.containsKey(leftChar) &&
                tHashmap.get(leftChar) == sHashmap.get(leftChar) + 1) {
                    need++;
                }
                l++;
            }
        }
        return res[1] != Integer.MAX_VALUE ? s.substring(res[0], res[1] + 1) : "";
    }
}
