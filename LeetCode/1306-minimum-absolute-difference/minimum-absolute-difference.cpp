class Solution {
public:
    vector<vector<int>> minimumAbsDifference(vector<int>& arr) {
        sort(arr.begin(), arr.end());
        int minDiff = INT_MAX, n = arr.size();
        vector<vector<int>> sol;

        for (int i = 1; i < n; i++) {
            minDiff = min(minDiff, arr[i] - arr[i - 1]);
        } //for

        int l = 0, r = 1;

        while (r < n) {
            if (arr[r] - arr[l] < minDiff) {
                r++;
            } else if (arr[r] - arr[l] == minDiff) {
                sol.push_back({arr[l], arr[r++]});
            } else {
                l++;
            } //if
        } //while

        return sol;
    } //minDiff 
};