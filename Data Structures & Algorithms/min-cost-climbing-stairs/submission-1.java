class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] minCost = new int[] {0, 0};
        for (int i = 2; i < n + 1; i++) {
            int temp = minCost[1];
            minCost[1] = Math.min(minCost[1] + cost[i-1], minCost[0] + cost[i-2]);
            minCost[0] = temp;
        }
        return minCost[1];
    }
}
