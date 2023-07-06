class Solution {
public:
    int arraySign(vector<int>& nums) {
        int negs = 0;
        bool hasZero = false;

        for (int num : nums) {
            if (num == 0) hasZero = true;
            else if (num < 0) negs++;
        } //for

        return hasZero ? 0 : negs % 2 == 1 ? -1 : 1;
    } //arrSign
};