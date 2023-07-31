class Solution {
public:
    int majorityElement(vector<int>& nums) {
        unordered_map <int, int> um;
        for (int num : nums) {
            if (++um[num] > nums.size()/2) return num;
        } //for
        return -1;
    } //majority
};