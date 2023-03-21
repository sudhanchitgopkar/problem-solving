class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long len = 0, sol = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                len++;
            else {
                sol += (len * ++len)/2;
                len = 0;
            }
        } //for
        return sol + (len * ++len)/2;
    } //zeroFilled
} //Sol

//0 -> 1
//0 0 -> 2 + 1
//0 0 0 -> 3 + 2 + 1
//0 0 0 0 -> 4 + 3 + 2 + 1