class Solution {
public:
    vector<int> sortItems(int n, int m, vector<int>& group, vector<vector<int>>& beforeItems) {
        vector<int> sol;
        vector<vector<int>> items (m + 1, vector<int> ());
        vector<vector<int>> intra (m, vector<int>());
        vector<vector<int>> intra_adj (n, vector<int>());
        unordered_map<int, unordered_set<int>> inter_adj;
        unordered_map <int, int> inter_in_deg;
        queue <int> q;
        
        for (int i = 0; i < n; i++) {
            items[group[i] == -1 ? m : group[i]].push_back(i);
            for (int prereq : beforeItems[i]) {
                if (group[prereq] == group[i]) {
                    intra_adj[prereq].push_back(i);
                } //if
            } //for
        } //for

        for (int i = 0; i < m; i++) {
            vector<int> res = topsort(intra_adj, items[i]);
            if (res.size() > 0 && res[0] == -1) return {};
            intra[i] = res;
        } //for

        for (int i = 0; i < n; i++) {
            if (!inter_adj.count(group[i] == -1 ? i * -1 - 1 : group[i])) {
                inter_adj.insert({group[i] == -1 ? i * -1 - 1 : group[i], unordered_set<int>()});
            } //if
            for (int prereq : beforeItems[i]) {
                if (group[prereq] != group[i] || group[prereq] == -1) {
                    if (!inter_adj.count(group[prereq] == -1 ? prereq * -1 - 1 : group[prereq])) {
                        inter_adj.insert({group[prereq] == -1 ? prereq * -1 - 1 : group[prereq], unordered_set<int>()});
                    } //if
                    inter_adj[group[prereq] == -1 ? prereq * -1 - 1 : group[prereq]].insert(group[i] == -1 ? i * -1 - 1 : group[i]);
                } //if
            } //for
        } //for

        for (auto entry : inter_adj) {
            //cout << entry.first << ":";
            if (!inter_in_deg.count(entry.first)) inter_in_deg[entry.first] = 0;
            for (int next : entry.second) {
                inter_in_deg[next]++;
                //cout << next << " ";
            } //for
            //cout << "\n---\n";
        } //for

        for (auto entry : inter_in_deg) {
            if (entry.second == 0) {
                q.push(entry.first);
            } //if
        } //for

        while (!q.empty()) {
            int curr = q.front();
            q.pop();

            for (int next : inter_adj[curr]) {
                inter_in_deg[next]--;
                if (inter_in_deg[next] == 0) {
                    q.push(next);
                } //if
            } //for

            if (curr < 0) {
                sol.push_back(abs(curr + 1));
            } else {
                for (int val : intra[curr]) {
                    sol.push_back(val);
                } //for
            } //if
        } //while

        for (auto entry : inter_in_deg) {
            if (entry.second != 0) {
                return {};
            } //if
        } //for

        return sol;
    } //sort

    vector<int> topsort(vector<vector<int>>& intra_adj, vector<int>& items) {
        unordered_map <int, int> in_deg;
        vector<int> sorted (0);
        queue <int> q;

        for (int item : items) {
            if (!in_deg.count(item)) in_deg[item] = 0;
            for (int next : intra_adj[item]) {
                in_deg[next]++;
            } //for
        } //for

        for (auto entry : in_deg) {
            if (entry.second == 0) {
                q.push(entry.first);
            } //if
        } //for

        while (!q.empty()) {
            int curr = q.front();
            q.pop();

            for (int next : intra_adj[curr]) {
                in_deg[next]--;
                if (in_deg[next] == 0) {
                    q.push(next);
                } //if
            } //for

            sorted.push_back(curr);
        } //while
        
        for (auto entry : in_deg) {
            if (entry.second != 0) {
                return {-1};
            } //if
        } //for

        return sorted;
    } //for
};