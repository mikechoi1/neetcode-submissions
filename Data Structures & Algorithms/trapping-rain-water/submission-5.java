class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int maxLHeight = 0, maxRHeight = 0;
        int maxWater = 0;
        while (l <= r) {
            // set maxheights
            maxLHeight = Math.max(maxLHeight, height[l]);
            maxRHeight = Math.max(maxRHeight, height[r]);
            if (height[l] <= height[r]) {
                int lowerMaxHeight = Math.min(maxLHeight, maxRHeight);
                int curWater = Math.max(lowerMaxHeight - height[l], 0);
                maxWater += curWater;
                l++;
            }
            else {
                int lowerMaxHeight = Math.min(maxLHeight, maxRHeight);
                int curWater = Math.max(lowerMaxHeight - height[r], 0);
                maxWater += curWater;
                r--;
            }
        }
        return maxWater;
    }
}
