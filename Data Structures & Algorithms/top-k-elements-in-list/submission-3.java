class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        int n = nums.length;
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] buckets = new List[n + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            buckets[entry.getValue()].add(entry.getKey());
        }

        int[] topKNumbers = new int[k];
        int index = 0;
        int i = buckets.length - 1;
        while (i > 0 && index < k) {
            for (int num : buckets[i]) {
                if (index < k) {
                    topKNumbers[index] = num;
                    index++;
                }
            }
            i--;
        }
        return topKNumbers;
    }
}
