class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int index = 0;
        while (index < str.length()) {
            int endOfWordLength = str.indexOf('#', index);
            int wordLength = Integer.parseInt(str.substring(index, endOfWordLength));
            index = endOfWordLength + 1;
            String word = str.substring(index, index + wordLength);
            index += wordLength;
            res.add(word);
        }
        return res;
    }
}
