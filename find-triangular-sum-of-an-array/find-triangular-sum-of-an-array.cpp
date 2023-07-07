class Solution {
public:
    int triangularSum(vector<int>& nums) {
        int n = nums.size();

        while (n > 0) {
            for (int i = 0; i < n - 1; i++) {
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            } //for
            --n;
        } //while

        return nums[0];
    } //trisum
};