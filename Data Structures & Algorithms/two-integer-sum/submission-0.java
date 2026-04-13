class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int dif = target - nums[i];
            if (hashmap.containsKey(dif)) {
                return new int[] {hashmap.get(dif), i};
            }
            hashmap.put(nums[i], i);
        }
        return new int[] {};
    }
}
