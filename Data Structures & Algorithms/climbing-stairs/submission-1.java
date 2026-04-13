class Solution {
    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int[] prevSteps = new int[] {1, 2};
        for (int i = 3; i <= n; i++) {
            int temp = prevSteps[1];
            prevSteps[1] += prevSteps[0];
            prevSteps[0] = temp;
        }
        return prevSteps[1];
    }
}
