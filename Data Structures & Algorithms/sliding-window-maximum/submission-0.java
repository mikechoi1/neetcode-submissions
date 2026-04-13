class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        // max heap, [value, index]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            pq.offer(new int[] {nums[r], r});
            if (pq.size() >= k) {
                while (pq.peek()[1] <= r - k) {
                    pq.poll();
                }
                res[l++] = pq.peek()[0];
            }
        }
        return res;
    }
}
