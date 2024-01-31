class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temps) {
        int n = temps.size();
        stack <int> s;
        vector<int> sol (n, 0);

        s.push(0);

        for (int i = 1; i < n; i++) {
            while (!s.empty() && temps[i] > temps[s.top()]) {
                sol[s.top()] = i - s.top();
                s.pop();
            } //while

            s.push(i);
        } //for

        return sol;
    } //dailyTemps
};

//71,69,70,72