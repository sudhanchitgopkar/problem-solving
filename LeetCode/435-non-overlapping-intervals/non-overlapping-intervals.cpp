class Solution {
public:
    int eraseOverlapIntervals(vector<vector<int>>& intervals) {
        if (intervals.empty()) return 0;
        int toKeep = 1, end = INT_MAX;

        sort(intervals.begin(), intervals.end(), [](const auto& a, const auto& b) {
            return a[1] < b[1];
        });

        end = intervals[0][1];
        
        for(int i = 1; i < intervals.size(); i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
                toKeep++;
            } //if
        } //for
        
        return intervals.size() - toKeep;
    }
};