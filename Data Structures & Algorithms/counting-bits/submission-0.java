class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int bit = 0; bit < 32; bit++) {
                if ((1 << bit & i) != 0) {
                    res[i]++;
                }
            }
        }
        return res;
    }
}
