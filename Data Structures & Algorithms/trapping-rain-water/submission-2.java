class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int maxL = 0, maxR = 0;
        int water = 0;
        while (l < r) {
            maxL = Math.max(maxL, height[l]);
            maxR = Math.max(maxR, height[r]);
            if (height[l] < height[r]) {
                water += maxL - height[l] > 0 ? maxL - height[l] : 0;
                l++;
            }
            else {
                water += maxR - height[r] > 0 ? maxR - height[r] : 0;
                r--;
            }
        }
        return water;
    }
}
