class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                while (l + 1 < r && nums[l + 1] == nums[l])
                        l++;
                while (r - 1 > l && nums[r - 1] == nums[r])
                    r--;
                int sum = nums[i] + nums[l] + nums[r];
                System.out.println(sum);
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                }
                else if (sum > 0) {
                    r--;
                }
                else {
                    l++;
                }
            }
        }
        return res;
    }
}
