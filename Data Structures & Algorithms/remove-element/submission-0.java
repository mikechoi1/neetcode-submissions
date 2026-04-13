class Solution {
    public int removeElement(int[] nums, int val) {
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                int j = i + 1;
                while (j < nums.length) {
                    if (nums[j] != val)
                        break;
                    j++;
                }
                if (j >= nums.length)
                    break;
                nums[i] = nums[j];
                nums[j] = val;
            }
            size++;
        }
        return size;
    }
}