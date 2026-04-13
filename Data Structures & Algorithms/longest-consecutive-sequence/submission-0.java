class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hashset = new HashSet<>();
        for (int num : nums) {
            hashset.add(num);
        }
        int longestLength = 0;
        for (int num : nums) {
            if (!hashset.contains(num - 1)) {
                int curLength = 0;
                // start of the sequence
                int i = num;
                while (hashset.contains(i)) {
                    curLength++;
                    i++;
                }
                longestLength = Math.max(longestLength, curLength);
            }
        }
        return longestLength;
    }
}
