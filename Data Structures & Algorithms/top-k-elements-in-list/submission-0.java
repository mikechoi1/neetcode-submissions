class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        Map<Integer, Integer> hashmap = new HashMap<>();
        for (int num : nums) {
            hashmap.put(num, hashmap.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : hashmap.entrySet()) {
            int num = entry.getKey(), freq = entry.getValue();
            buckets[freq].add(num);
        }

        int[] res = new int[k];
        int i = buckets.length - 1, numsAdded = 0;
        while (numsAdded < k && i >= 0) {
            for (int num : buckets[i]) {
                res[numsAdded++] = num;
                if (numsAdded == k) {
                    return res;
                }
            }
            i--;
        }
        return res;
    }
}
