class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            double aDist = Math.sqrt(Math.pow(a[0], 2) + Math.pow(a[1], 2));
            double bDist = Math.sqrt(Math.pow(b[0], 2) + Math.pow(b[1], 2));
            return Double.compare(bDist, aDist);
        });
        for (int[] point: points) {
            pq.offer(point);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.toArray(new int[0][]);
    }
}
