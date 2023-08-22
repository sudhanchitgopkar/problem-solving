class Solution {
public:
    int minInsertions(string s) {
        int sol = 0, open = 0;

        for (int i = 0; i < s.size(); i++) {
            if (s[i] == '(') {
                open++;
            } else {
                if (open == 0) {
                    sol++;
                } //if

                if (i == s.size() - 1) {
                    open = max(open - 1, 0);
                    sol++;
                } else if (s[i + 1] == ')') {
                    open = max(open - 1, 0);
                    i++;
                } else {
                    open = max(open - 1, 0);
                    sol++;
                } //if
            } //if
        } //for

        return sol + (open * 2);
    } //minInertions
};