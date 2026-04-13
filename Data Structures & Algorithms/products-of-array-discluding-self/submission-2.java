class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefixProduct = new int[n];
        int[] postfixProduct = new int[n];
        int product = 1;
        for (int i = 0; i < n; i++) {
            prefixProduct[i] = product;
            product *= nums[i];
        }
        product = 1;
        for (int i = n - 1; i >= 0; i--) {
            postfixProduct[i] = product;
            product *= nums[i];
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = prefixProduct[i] * postfixProduct[i];
        }
        return res;
    }
}  
