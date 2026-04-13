class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }
        // descending order
        Arrays.sort(pairs, (a, b) -> Integer.compare(b[0], a[0]));
        Stack<Double> stack = new Stack<>();
        for (int[] pair : pairs) {
            double time = (double) (target - pair[0]) / pair[1];
            if (!stack.isEmpty()) {
                if (time <= stack.peek()) {
                    continue;
                }
            }
            stack.push(time);
        }
        return stack.size();
    }
}
