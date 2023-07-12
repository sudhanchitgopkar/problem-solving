class Solution {
public:
    vector<int> eventualSafeNodes(vector<vector<int>>& graph) {
        int n = graph.size();
        vector<int> dp (n, -1);
        vector<int> sol;

        for (int i = 0; i < n; i++) {
            dfs(i, graph, dp);
        } //for

        for (int i = 0; i < n; i++) {
            if (dp[i] == 1) sol.push_back(i);
        } //for
        
        return sol;
    } //eventuallysafe

    int dfs(int curr, vector<vector<int>>& graph, vector<int>& dp) {
        if (graph[curr].size() == 0) {
            dp[curr] = 1;
            return dp[curr];
        } else if (dp[curr] != -1) {
            return dp[curr];
        } //if

        dp[curr] = 0;
        for (int next : graph[curr]) {
            if (dfs(next, graph, dp) == 0) {
                return dp[curr];
            } //if
        } //for

        dp[curr] = 1;
        return dp[curr];
    } //dfs
};