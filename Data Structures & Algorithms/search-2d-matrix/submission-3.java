class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l = 0 , r = m * n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            System.out.println(l + ", " + r + ", " + m);
            int row = mid / n, col = mid % n;
            if (matrix[row][col] == target) {
                return true;
            }
            if (matrix[row][col] > target) {
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        return false;
    }
}
