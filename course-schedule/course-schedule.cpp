class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prereqs) {
        vector<vector<int>> adj (numCourses);
        vector<int> seen (numCourses, -1);

        for (vector<int> prereq : prereqs) {
            adj[prereq[1]].push_back(prereq[0]);
        } //for

        for (int i = 0; i < numCourses; i++) {
            if (seen[i] == -1 && hasCycle(i, adj, seen)) {
                return false;
            } //if
        } //for

        return true;
    } //canFinish

    bool hasCycle (int curr, vector<vector<int>>& adj, vector<int>& seen) {
        if (seen[curr] == 1) {
            return true;
        } else if (seen[curr] == 0) {
            return false;
        } //if

        seen[curr] = 1;

        for (int next : adj[curr]) {
            if (hasCycle(next, adj, seen)) {
                return true;
            } //if
        } //for

        seen[curr] = 0;
        return false;
    } //cycle
};