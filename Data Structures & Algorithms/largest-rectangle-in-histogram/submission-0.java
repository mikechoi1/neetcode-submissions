class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int maxArea = 0, n = heights.length;
        for (int i = 0; i < n; i++) {
            int leftMostIndex = i;
            while (!stack.isEmpty() && heights[i] <= stack.peek()[0]) {
                int[] pop = stack.pop();
                maxArea = Math.max(maxArea, pop[0] * (i - pop[1]));
                leftMostIndex = pop[1];
            }
            stack.push(new int[] {heights[i], leftMostIndex});
        }
        while (!stack.isEmpty()) {
            int[] pop = stack.pop();
            maxArea = Math.max(maxArea, pop[0] * (n - pop[1]));
        }
        return maxArea;
    }
}
