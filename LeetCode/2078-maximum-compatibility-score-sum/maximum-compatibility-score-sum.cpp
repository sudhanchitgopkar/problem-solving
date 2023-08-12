class Solution {
public:
    int maxCompatibilitySum(vector<vector<int>>& students, vector<vector<int>>& mentors) {
        vector<bool> usedMentors (students.size());
        return dfs(0, 0, usedMentors, students, mentors);
    } //maxCompatibility

    int dfs(int i, int sum, vector<bool>& usedMentors, vector<vector<int>>& students, vector<vector<int>>& mentors) {
        if (i == students.size()) return sum;

        int res = 0;
        for (int j = 0; j < mentors.size(); j++) {
            if (usedMentors[j]) continue;
            usedMentors[j] = true;
            res = max(res, dfs(i + 1, sum + compat(students[i], mentors[j]), usedMentors, students, mentors));
            usedMentors[j] = false;
        } //for

        return res;
    } //dfs

    int compat (vector<int>& s, vector<int>& m) {
        int score = 0;

        for (int i = 0; i < s.size(); i++) {
            if (s[i] == m[i]) ++score;
        } //for

        return score; 
    } //diff
};