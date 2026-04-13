class Solution {
    // Important to talk about what the look out for
    // eg. special symbols that might affect the separator

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append('#').append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        // two pointers to grab the size of the string as well as the string itself
        int i = 0, j = 0;
        while (i < str.length()) {
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + length;
            String decodedString = str.substring(i, j);
            res.add(decodedString);
            i = j;
        }
        return res;
    }
}
