/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return true;
        }
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));
        Interval currentInterval = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval newInterval = intervals.get(i);
            if (newInterval.start < currentInterval.end) {
                return false;
            }
            currentInterval = newInterval;
        }
        return true;
    }
}
