class Solution {
    public int trap(int[] height) {
        int total = 0;
        int left = 0, right = height.length - 1;
        int maxLeft = 0, maxRight = 0;
        while (left <= right) {
            maxLeft = Math.max(maxLeft, height[left]);
            maxRight = Math.max(maxRight, height[right]);
            int lowerHeight = Math.min(maxLeft, maxRight);
            if (height[left] < height[right]) {
                total += Math.max(0, lowerHeight - height[left]);
                left++;
            }
            else {
                total += Math.max(0, lowerHeight - height[right]);
                right--;
            }
        }
        return total;
    }
}
