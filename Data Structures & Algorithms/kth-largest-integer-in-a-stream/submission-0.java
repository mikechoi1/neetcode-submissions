class KthLargest {

    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for (int num : nums) {
            pq.offer(num);
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        int[] temps = new int[k];
    for (int i = 0; i < k; i++) {
        temps[i] = pq.poll();
    }
    for (int i = 0; i < k; i++) {
        pq.offer(temps[i]);
    }
    return temps[k - 1];
    }
}
