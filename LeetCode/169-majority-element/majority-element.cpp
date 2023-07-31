class Solution {
public:
    int majorityElement(vector<int>& nums) {
        unordered_map <int, int> um;
        for (int num : nums) um[num]++;
        for (auto entry : um)
            if (entry.second > nums.size()/2) return entry.first;
        return -1;
    } //majority
};