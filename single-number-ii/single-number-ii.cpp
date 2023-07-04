class Solution {
public:
    int singleNumber(vector<int>& nums) {
        unordered_map <int, int> freq;

        for (int num : nums) freq[num]++;

        for (auto entry : freq)
            if (entry.second == 1) return entry.first;

        return -1; //unreachable
    } //singleNumber
};