class Solution {
public:
    vector<int> sortArrayByParityII(vector<int>& nums) {
        int n = nums.size(), l = 0, r = 1;
        vector<int> sol (n, 0);

        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) {
                sol[l] = nums[i];
                l += 2;
            } else {
                sol[r] = nums[i];
                r += 2;
            } //if
        } //for

        return sol;
    } //sortByParity
};