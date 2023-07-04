#define long long
class Solution {
public:
    int minimizedMaximum(int n, vector<int>& nums) {
        long long sum = 0, l = 1, r = -1, sol = INT_MAX;

        for (int num : nums) sum += num;
        r = sum;

        while (l < r) {
            long long m = l + (r - l)/2;
            if (check(n, m, nums)) {
                sol = min(sol, m);
                r = --m;
            } else {
                l = ++m;
            } //if
        } //while

        return min(sol, check(n, l, nums) ? l : INT_MAX);
    } //minMax

    bool check (int n, long long m, vector<int>& nums) {
        long long sol = 0;

        for (int num : nums) {
            sol += ceil(num * 1.0/m);
            if (sol > n) return false;
        } //for

        return true;
    } //check
};