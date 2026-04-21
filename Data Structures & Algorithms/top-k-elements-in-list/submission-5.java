class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            hashmap.put(n, hashmap.getOrDefault(n, 0) + 1);
        }
        List<int[]> numList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : hashmap.entrySet()) {
            numList.add(new int[] {entry.getKey(), entry.getValue()});
        }
        numList.sort((a, b) -> Integer.compare(b[1], a[1]));
        int[] res = new int[k];
        int index = 0;
        while (index < k) {
            res[index] = numList.get(index)[0];
            index++;
        }
        return res;
    }
}
