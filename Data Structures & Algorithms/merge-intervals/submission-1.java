class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();
        int[] curInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] newInterval = intervals[i];
            if (newInterval[0] <= curInterval[1]) {
                curInterval[1] = Math.max(curInterval[1], newInterval[1]);
            }
            else {
                res.add(curInterval);
                curInterval = newInterval;
            }
        }
        res.add(curInterval);
        return res.toArray(new int[0][]);
    }
}
