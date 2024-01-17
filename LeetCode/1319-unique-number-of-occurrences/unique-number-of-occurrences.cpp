class Solution {
public:
    bool uniqueOccurrences(vector<int>& arr) {
        int n = arr.size();
        unordered_map<int, int> freq;
        vector<int> buckets (n + 1, -1);

        //populate freq map
        for (int val : arr) freq[val]++;
        //check for conflicting freqs
        for (auto [v, f] : freq) {
            if (buckets[f] != -1) return false;
            else buckets[f] = v;
        } //for

        return true;
    } //uniqueOccurrences
};