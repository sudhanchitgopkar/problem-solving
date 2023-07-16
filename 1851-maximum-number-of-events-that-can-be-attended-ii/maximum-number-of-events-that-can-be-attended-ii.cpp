class Solution {
public:
    int maxValue(vector<vector<int>>& events, int k) {
        int n = events.size();
        //sort by start date
        sort(events.begin(), events.end(), 
        [] (const vector<int>& a, const vector<int>& b) {
            return a[0] < b[0];   
        });

        vector<vector<int>> dp (n, vector<int> (k + 1, -1));
        solve(0, k, events, dp);
        return dp[0][k];
    } //maxVal

    int solve(int i, int k, vector<vector<int>>& events, vector<vector<int>>& dp) {
        if (i == events.size() || k == 0) {
            //if we can't take any more events
            return 0;
        } else if (dp[i][k] != -1) {
            //if we've already done this computation
            return dp[i][k];
        } //if

        //do what's better: taking this event and moving on or not taking it
        dp[i][k] = max(events[i][2] + solve(nextEvent(i, events), k - 1, events, dp),
                       solve(i + 1, k, events, dp));
        return dp[i][k];
    } //solve
    
    int nextEvent(int currEvent, vector<vector<int>>& events) {
        int l = currEvent, r = events.size() - 1;
        //use a binary search to find the next possible event to attend
        while (l <= r) {
            int m = l + ((r - l)/2);
            if (events[m][0] > events[currEvent][1]) {
                r = --m;
            } else {
                l = ++m;
            } //if
        } //while
        return l;
    } //nextEvent
};