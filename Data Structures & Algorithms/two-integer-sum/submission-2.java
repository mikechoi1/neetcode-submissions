class Solution {
    public int[] twoSum(int[] nums, int target) {
        // <number, index>
        Map<Integer, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (hashmap.containsKey(target - n)) {
                int firstIndex = hashmap.get(target - n);
                return new int[] {firstIndex, i};
            }
            hashmap.put(n, i);
        }
        return new int[] {};
    }
}
