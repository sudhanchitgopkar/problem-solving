class Solution {
public:
    int getMinDistance(vector<int>& nums, int target, int start) {
        int n = nums.size(), sol = INT_MAX;

        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                sol = min(sol, abs(i - start));
            } //if
        } //for

        return sol;
    } //getMinDist
};