class Solution {
public:
    int eraseOverlapIntervals(vector<vector<int>>& intervals) {
        if (intervals.size() == 1) return 0;

        int n = intervals.size(), l = 0, r = 1, sol = 0;
        sort(intervals.begin(), intervals.end());

        while (r < n) {
            if (intervals[l][1] >  intervals[r][0]) {
                if (intervals[l][1] <= intervals[r][1]) {
                    l = l;
                } else {
                    l = r;
                } //if
                sol++;
            } else {
                l = r;
            } //if
            r++;
        } //while

        return sol;
    } //eraseOverlapping
};