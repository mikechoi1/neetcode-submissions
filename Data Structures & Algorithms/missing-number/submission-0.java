class Solution {
    public int missingNumber(int[] nums) {
        int xor = nums.length;
        for (int i = 0; i < nums.length; i++) {
            xor ^= i ^ nums[i];
            System.out.println(xor);
        }
        return xor;
    }
}


/*
0 = 0000
1 = 0001
2 = 0010
3 = 0011
4 = 0100

bit operations:
& and
| or
~ not
^ xor
<< left shift
>> right shift
>>> right shift with 0 padding
*/
