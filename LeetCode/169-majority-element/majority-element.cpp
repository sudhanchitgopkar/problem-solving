class Solution {
public:
    int majorityElement(vector<int>& nums) {
        map <int, int> freq;

        for (int num : nums) {
            if (++freq[num] > nums.size()/2) return num;
        } //for

        return -1;
    } //majority
};