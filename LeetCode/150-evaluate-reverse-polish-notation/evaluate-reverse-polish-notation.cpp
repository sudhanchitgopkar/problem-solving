class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        stack <int> nums;
        for (string token : tokens) {
            if (isNum(token)) {
                nums.push(stoi(token));
            } else {
                int a = nums.top();
                nums.pop();
                int b = nums.top();
                nums.pop();

                if (token == "+") nums.push(a + b);
                else if (token == "*") nums.push(a * b);
                else if (token == "-") nums.push(b - a);
                else if (token == "/") nums.push(b / a);
            } //if
        } //for

        return nums.top();
    } //evalRPN

private:
    bool isNum(string s) {
        return s.size() > 1 || isdigit(s[0]);
    } //isNum
};