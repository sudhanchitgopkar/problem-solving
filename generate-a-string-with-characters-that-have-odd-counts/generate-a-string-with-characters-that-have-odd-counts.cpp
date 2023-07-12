class Solution {
public:
    string generateTheString(int n) {
        string sol;

        for (int i = 0; i < n; i++) {
            sol += 'a';
        } //for

        if (n % 2 == 0) {
            sol.pop_back();
            sol += 'b';
        } //if

        return sol;
    } //genString
};