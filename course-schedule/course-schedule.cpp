class Solution {
public:
    bool canFinish(int n, vector<vector<int>>& prereqs) {
        vector<int> sorted (n), in (n);
        vector<vector<int>> adj (n);
        queue <int> q;

        //populate adj and in list
        for (vector<int> prereq : prereqs) {
            adj[prereq[1]].push_back(prereq[0]);
            in[prereq[0]]++;
        } //for

        for (int i = 0; i < n; i++) {
            if (in[i] == 0) {
                q.push(i);
            } //if
        } //for

        while (!q.empty()) {
            int curr = q.front();
            q.pop();
            for (int next : adj[curr]) {
                if (--in[next] == 0) {
                    q.push(next);
                } //if
            } //if
            sorted.push_back(curr);
        } //while

        for (int i = 0; i < n; i++) {
            if (in[i] != 0) {
                return false;
            } //if
        } //for
        
        return true;
    } //canFinish
};