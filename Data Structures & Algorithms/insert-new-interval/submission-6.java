class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int start = newInterval[0], end = newInterval[1];
        boolean newAdded = false;
        for (int[] interval : intervals) {
            if (newAdded || interval[1] < newInterval[0]) {
                res.add(interval);
            }
            else if (interval[0] > newInterval[1]) {
                res.add(newInterval);
                res.add(interval);
                newAdded = true;
            }
            else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        if (!newAdded) {
            res.add(newInterval);
        }
        return res.toArray(new int[res.size()][]);
    }
}
