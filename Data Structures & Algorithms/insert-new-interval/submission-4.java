class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        boolean added = false;
        for (int[] interval : intervals) {
            if (added || interval[1] < newInterval[0]) {
                res.add(interval);
            }
            else if (newInterval[1] < interval[0]) {
                res.add(newInterval);
                added = true;
                res.add(interval);
            }
            else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        if (!added) {
            res.add(newInterval);
        }
        return res.toArray(new int[0][]);
    }
}
