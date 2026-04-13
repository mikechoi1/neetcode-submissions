class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];
        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[1] < start) {
                res.add(interval);
            }
            else if (interval[0] > end) {
                res.add(new int[] {start, end});
                start = interval[0];
                end = interval[1];
            }
            else {
                start = Math.min(start, interval[0]);
                end = Math.max(end, interval[1]);
            }
        }
        res.add(new int[] {start, end});
        return res.toArray(new int[0][]);
    }
}
