class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // need to keep track of all nodes visited
        // dfs or bfs from node k
        // things to look out for:
        // 1. may be mult ways to visit node, take shortest time it takes to visit each node
        // parameters: visited nodes and time it takes to get there (boolean[][]), cur node (int), times (int[][])
        Map<Integer, List<Pair<Integer,Integer>>> hashmap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            hashmap.put(i, new ArrayList<>());
        }
        for (int[] time : times) {
            hashmap.get(time[0]).add(new Pair(time[1], time[2]));
        }
        Queue<Integer> queue = new LinkedList<>();
        int[] timeTaken = new int[n + 1];
        Arrays.fill(timeTaken, -1);
        timeTaken[k] = 0;
        queue.offer(k);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (Pair<Integer, Integer> value : hashmap.get(node)) {
                int destNode = value.getKey();
                int timeCost = value.getValue();
                if (timeTaken[destNode] == -1 || timeTaken[destNode] > timeTaken[node] + timeCost) {
                    timeTaken[destNode] = timeTaken[node] + timeCost;
                    queue.offer(destNode);
                }
            }
        }
        int totalTime = 0;
        for (int i = 1; i < timeTaken.length; i++) {
            if (timeTaken[i] == -1) {
                return -1;
            }
            totalTime = Math.max(totalTime, timeTaken[i]);
        }
        return totalTime;
    }
}
