class Solution {
public:
    int minimizeMax(vector<int>& nums, int p) {
        sort(nums.begin(), nums.end());
        int n = nums.size(), l = 0, r = nums[n - 1] - nums[0];

        while (l <= r) {
            int m = l + (r - l)/2, possPairs = 0;

            for (int i = 0; i < n - 1 && possPairs < p; i++) {
                if ((nums[i + 1] - nums[i]) < m) {
                    possPairs++;
                    i++;
                } //if
            } //for

            if (possPairs >= p) {
                r = --m;
            } else {
                l = ++m;
            } //if
        } //while

        return max(--l, 0);
    } //minMax
};