class Solution {
public:
    vector<int> rearrangeArray(vector<int>& nums) {
        queue<int> pos, neg;
        vector<int> sol;

        for (int num : nums) {
            if (num > 0) pos.push(num);
            else neg.push(num);
        } //for

        while (!pos.empty()) {
            sol.push_back(pos.front());
            sol.push_back(neg.front());
            pos.pop();
            neg.pop();
        } //while

        return sol;
    } //rearr
};