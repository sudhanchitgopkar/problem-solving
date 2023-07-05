class Solution {
public:
    int longestSubarray(vector<int>& nums) {
        int l = 0, r = 0, n = nums.size();
        int sum = 0, sol = 0, num0s = 0;

        while (r < n) {
            if (nums[r++] == 0) num0s++;
            else sum++;

            while (num0s > 1) {
                if (nums[l++] == 0) num0s--;
                else sum--;
            } //while
            
            sol = max(sum, sol);
        } //while

        return sol == n ? n - 1 : sol;
    } //longestSubarr
};