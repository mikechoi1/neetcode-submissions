class Solution {
    public int trap(int[] height) {
        // start from left and right
        // if next height is larger, move there
        // if next height is smaller, the height difference
        // between the next height and the smaller of the two sides

        int maxLeftHeight = 0, maxRightHeight = 0, waterTrapped = 0;
        int l = 0, r = height.length - 1;
        while (l < r && height[l] <= height[l + 1]) {
            l++;
        }
        while (r > l && height[r] <= height[r - 1]) {
            r--;
        }
        
        while (l < r) {
            maxLeftHeight = Math.max(maxLeftHeight, height[l]);
            maxRightHeight = Math.max(maxRightHeight, height[r]);
            int shorterMaxHeight = Math.min(maxLeftHeight, maxRightHeight);
            if (height[l] <= height[r]) {
                waterTrapped += shorterMaxHeight - height[l];
                l++;
            }
            else {
                waterTrapped += shorterMaxHeight - height[r];
                r--;
            }
        }
        return waterTrapped;
    }
}
