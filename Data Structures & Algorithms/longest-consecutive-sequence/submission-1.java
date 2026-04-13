class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hashset = new HashSet<>();
        for (int num : nums) {
            hashset.add(num);
        }
        int longest = 0;
        for (int num : hashset) {
            if (!hashset.contains(num - 1)) {
                int length = 1;
                while (hashset.contains(num + length)) {
                    length++;
                }
                longest = Math.max(longest, length);
            }

        }
        return longest;
    }
}
