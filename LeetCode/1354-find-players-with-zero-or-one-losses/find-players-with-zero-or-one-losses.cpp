class Solution {
public:
    vector<vector<int>> findWinners(vector<vector<int>>& matches) {
        map <int, int> wins, losses;
        vector<int> noLoss, oneLoss;

        for (auto & match : matches) {
            wins[match[0]]++;
            losses[match[1]]++;
        } //for

        for (auto & entry : wins) {
            if (!losses.count(entry.first)) {
                noLoss.push_back(entry.first);
            } //if
        } //for

        for (auto & entry : losses) {
            if (entry.second == 1) {
                oneLoss.push_back(entry.first);
            } //if
        } //for

        vector<vector<int>> sol;
        sol.push_back(noLoss);
        sol.push_back(oneLoss);

        return sol;
    } //findWinners
};