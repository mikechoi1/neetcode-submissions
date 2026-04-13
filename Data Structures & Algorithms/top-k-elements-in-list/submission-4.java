class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hashmap = new HashMap<>();
        for (int num : nums) {
            hashmap.put(num, hashmap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.getValue(), b.getValue()));
        for (Map.Entry<Integer, Integer> entry : hashmap.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            pq.offer(new Pair<>(num, freq));
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] res = new int[k];
        int index = 0;
        while (index < k && !pq.isEmpty()) {
            res[index] = pq.poll().getKey();
            index++;
        }
        return res;
    }
}
