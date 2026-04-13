class Solution {
    public int maxArea(int[] heights) {
        int maxWater = 0;
        int l = 0, r = heights.length - 1;
        while (l < r) {
            int lowerHeight = Math.min(heights[l], heights[r]);
            int area = (r - l) * lowerHeight;
            maxWater = Math.max(maxWater, area);
            if (heights[l] <= heights[r]) {
                l++;
            }
            else {
                r--;
            }
        }
        return maxWater;
    }
}
