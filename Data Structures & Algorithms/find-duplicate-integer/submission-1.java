class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> hashset = new HashSet<>();
        for (int num : nums) {
            if (hashset.contains(num)) {
                return num;
            }
            hashset.add(num);
        }
        return -1;
    }
}
