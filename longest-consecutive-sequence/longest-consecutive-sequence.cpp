class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        unordered_set<int> seen;
        int sol = 0;

        for (int num : nums) seen.insert(num);

        for (int num : seen) {
            if (seen.count(num - 1)) continue;
            int range = 0;
            while (seen.count(num + range)) {
                range++;
            } //while
            sol = max(range, sol);
        } //for

        return sol;
    } //longestConsecutive
};