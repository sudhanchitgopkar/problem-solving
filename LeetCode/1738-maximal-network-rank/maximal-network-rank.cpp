class Solution {
public:
    int maximalNetworkRank(int n, vector<vector<int>>& roads) {
        vector<unordered_set<int>> adj;
        int sol = 0;

        for (int i = 0; i < n; i++) {
            adj.push_back(unordered_set<int> ());
        } //for

        for (vector<int> & road : roads) {
            adj[road[0]].insert(road[1]);
            adj[road[1]].insert(road[0]);
        } //for

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int res = adj[i].size() + adj[j].size() - (adj[i].count(j));
                sol = res > sol ? res : sol;
            } //for
        } //for

        return sol;
    } //maxNetworkRank
};