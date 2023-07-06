class Solution {
public:
    int minAddToMakeValid(string str) {
        stack<char> s;
        int sol = 0;

        for (int i = 0; i < str.size(); i++) {
            if (str.at(i) == '(') s.push(')');
            else if (s.empty()) sol++;
            else s.pop();
        } //for

        return sol + s.size();
    } //minToMakeValid
};