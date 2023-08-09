class Solution {
public:
    int minimizeMax(vector<int>& nums, int p) {
        sort(nums.begin(), nums.end());
        int n = nums.size(), l = 0, r = nums[n - 1] - nums[0], sol = r;

        while (l <= r) {
            int m = l + (r - l)/2, possPairs = 0;

            for (int i = 1; i < n && possPairs < p; i++) {
                if ((nums[i] - nums[i - 1]) <= m) {
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

        return l;
    } //minMax
};