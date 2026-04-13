class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            int temp = temperatures[i];
            while (!stack.isEmpty() && temp > stack.peek()[0]) {
                int[] popped = stack.pop();
                res[popped[1]] = i - popped[1];
            }
            stack.push(new int[] {temp, i});
        }
        while (!stack.isEmpty()) {
            int[] popped = stack.pop();
            res[popped[1]] = 0;
        }
        return res;
    }
}
