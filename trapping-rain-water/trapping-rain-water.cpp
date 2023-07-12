class Solution {
public:
    int trap(vector<int>& height) {
        int n = height.size(), sol = 0;
        vector<int> lmax(n, 0), rmax(n, 0);

        lmax[0] = height[0];
        rmax[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            lmax[i] = max(lmax[i - 1], height[i]);
            rmax[n - i - 1] = max(rmax[n - i], height[n - i - 1]);
        } //for

        for (int i = 0; i < n; i++) {
            if (i == 0 || i == n - 1) {
                continue;
            } else {
                int water = min(lmax[i - 1], rmax[i + 1]) - height[i];
                if (water > 0) sol += water;
            } //if
        } //for

        return sol;
    } //trap
};