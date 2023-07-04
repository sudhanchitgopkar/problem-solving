class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int sol = 0;

        for (int num : nums) sol = sol ^ num;

        return sol;
    } //singleNumber
};