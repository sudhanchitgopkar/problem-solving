class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        int n = nums.size(), l = 0, r = 0;
        int curr = 0, sol = INT_MAX;

        while (r < n) {
            curr += nums[r++];

            while (curr >= target) {
                sol = min(r - l, sol);
                curr -= nums[l++];
            } //while
        } //while
        
        return sol == INT_MAX ? 0 : sol;
    } //minSubarrLen
};