class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Pair<Integer,Integer>>> hashmap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            hashmap.put(i, new ArrayList<>());
        }
        for (int[] time : times) {
            hashmap.get(time[0]).add(new Pair(time[1], time[2]));
        }
        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> Integer.compare(a.getKey(), b.getKey()));
        boolean[] visited = new boolean[n + 1];
        int totalTime = 0;
        queue.offer(new Pair(0, k));
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> poll = queue.poll();
            int node = poll.getValue();
            int timeCost = poll.getKey();
            if (visited[node]) {
                continue;
            }
            totalTime = timeCost;
            visited[node] = true;
            for (Pair<Integer, Integer> value : hashmap.get(node)) {
                int destNode = value.getKey();
                int destCost = value.getValue();
                if (!visited[destNode]) {
                    queue.offer(new Pair(totalTime + destCost, destNode));
                }
            }
        }
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                return -1;
            }
        }
        return totalTime;
    }
}
