class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        if (piles == null || piles.length > h) {
            return -1;
        }
        int l = 1, r = 0;
        for (int pile : piles) {
            r = Math.max(r, pile);
        }
        while (l < r) {
            int m = l + (r - l) / 2;
            int hours = countHours(piles, m);
            if (hours <= h) {
                r = m;
            }
            else {
                l = m + 1;
            }
        }
        return l;
    }

    private int countHours(int[] piles, int eatRate) {
        int hours = 0;
        for (int pile : piles) {
            hours += (pile - 1) / eatRate + 1;
        }
        return hours;
    }
}
