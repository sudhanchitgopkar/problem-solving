class Solution {
public:
    int minSpeedOnTime(vector<int>& dists, double deadline) {
        if (dists.size() - 1 >= deadline) return -1;
        int l = 0, n = dists.size(), r = 1e7;

        while (l <= r) {
            int m = l + (r - l)/2;
            bool can = check(dists, deadline, m);
            if (can) {
                r = --m;
            } else {
                l = ++m;
            } //if
        } //while   

        return l == 0 ? 1 : l;
    } //minSpeedOnTime

    bool check (vector<int>& dists, double deadline, int speed) {
        double currTime = 0.0;

        for (int i = 0; i < dists.size(); i++) {
            currTime += ((dists[i] * 1.0)/speed);
            if (i != dists.size() - 1) currTime = ceil(currTime);
        } //for

        return currTime <= deadline;
    } //can
};