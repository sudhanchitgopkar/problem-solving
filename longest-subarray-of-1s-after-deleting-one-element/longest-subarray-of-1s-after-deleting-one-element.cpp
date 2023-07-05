class Solution {
public:
    int longestSubarray(vector<int>& nums) {
        int n = nums.size(), sol = -1;
        vector<int> pre (n, 0), post(n, 0);

        pre[0] = nums[0];
        for (int i = 1; i < n; i++) {
            pre[i] = nums[i] == 0 ? 0 : pre[i - 1] + 1;
        } //for

        post[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            post[i] = nums[i] == 0 ? 0 : post[i + 1] + 1;
        } //for

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                if (i == 0) {
                    sol = max(sol, post[1]);
                } else if (i == n - 1) {
                    sol = max(sol, pre[n - 2]);
                } else {
                    sol = max(sol, pre[i - 1] + post[i + 1]);
                } //if
            } //if
        } //for

        return sol == -1 ? n - 1 : sol;
    } //longestSubarr
};