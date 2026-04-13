class Solution {
    public boolean isHappy(int n) {
        Set<Integer> hashset = new HashSet<>();
        while (n != 1) {
            if (hashset.contains(n)) {
                return false;
            }
            hashset.add(n);
            int sumOfSquares = 0;
            while (n > 0) {
                sumOfSquares += Math.pow(n % 10, 2);
                n /= 10;
            }
            n = sumOfSquares;
        }
        return true;
    }
}
