class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for (char task : tasks) {
            counts[task - 'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b, a));
        Queue<int[]> cooldown = new LinkedList<>();
        for (int c : counts) {
            if (c > 0) {
                pq.offer(c);
            }
        }
        int time = 0;
        while (!pq.isEmpty() || !cooldown.isEmpty()) {
            time++;
            if (!cooldown.isEmpty() && time >= cooldown.peek()[1]) {
                pq.offer(cooldown.poll()[0]);
            }
            if (!pq.isEmpty()) {
                int count = pq.poll();
                if (count - 1 > 0) {
                    cooldown.offer(new int[] {count - 1, time + n + 1});
                }
            }
        }
        return time;
    }
}
