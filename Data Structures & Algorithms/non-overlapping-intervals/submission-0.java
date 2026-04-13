class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int n = intervals.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (intervals[j][1] <= intervals[i][0]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }
        int maxNonOverlap = 0;
        for (int max : dp) {
            maxNonOverlap = Math.max(maxNonOverlap, max);
        }
        return n - maxNonOverlap;
    }
}
