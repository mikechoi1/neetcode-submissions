class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hashset = new HashSet<>();
        for (int num : nums) {
            hashset.add(num);
        }
        int longestLength = 0;
        for (int num : nums) {
            if (hashset.contains(num - 1)) {
                continue;
            }
            int length = 0;
            while (hashset.contains(num + length)) {
                length++;
            }
            longestLength = Math.max(longestLength, length);
        }
        return longestLength;
    }
}
